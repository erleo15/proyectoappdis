package ec.edu.ups.datos;

import java.util.List;

import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.Query;

import ec.edu.ups.modelo.Pelicula;
import ec.edu.ups.modelo.Usuario;

@Stateless
public class PeliculaDAO {

	@Inject
	EntityManager em;
	

	/**
	 * Metodo que inserta un nuevo objeto de la clase 
	 * a la base
	 * @param pelicula representa la instancia en cuestion que 
	 * se va a ingresar
	 */
	public boolean insert(Pelicula pelicula) {
		try { 
		em.persist(pelicula);
		return true;
		}catch(Exception e) {
			e.printStackTrace();
		}
		return false;
	}
	
	/**
	 * Metodo que elimina un objeto de esta clase 
	 * en la base 
	 * @param id Representa la la primary key 
	 * de la tabla para que elimine el objeto
	 */
	public void delete(int id) {
		em.remove(find(id));
	}
	
	/**
	 * metodo que actualiza el objeto de esta clase en la BD
	 * 
	 * @param pelicula es la instancia de la clase en cuestiopn a administrar
	 */
	public void update(Pelicula pelicula) {
	
		em.remove(em.find(Pelicula.class, pelicula.getCodigoPelicula()));
		em.persist(pelicula);
		
	}
	
	/**
	 * Metodo que busca un objeto de esa clase
	 * en la baseD
	 * @param id es el valor de la primary key en la tabla
	 * @return retorna un objeto de la clase buscada
	 */
	public  Pelicula find(int id) {
		return em.find(Pelicula.class, id); 
	}
	
	/**
	 * Metodo que lista los objetos de esta clase guardados en
	 * la base de datos
	 * @return una lista con todos los resultados
	 */
	public List<Pelicula> list(){    
		return  em.createQuery("SELECT c from Pelicula c", Pelicula.class).getResultList(); 
	}
	
	public int getLastNumeroDetalle() {
		String jpql = "Select MAX(e.codigoPelicula) from Pelicula e";
		Query q = em.createQuery(jpql, Integer.class);
		return  (int)q.getSingleResult();
	}
	
	
}
