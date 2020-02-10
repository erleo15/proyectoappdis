package ec.edu.ups.datos;

import java.util.List;

import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.Query;

import ec.edu.ups.modelo.Pelicula; 

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
	public boolean delete(int id) {
		try {
		em.remove(find(id));
		return true;
		}catch(Exception e) {
			e.printStackTrace();
			return false;
		}
	}
	
	/**
	 * metodo que actualiza el objeto de esta clase en la BD
	 * 
	 * @param pelicula es la instancia de la clase en cuestiopn a administrar
	 */
	public boolean update(Pelicula pelicula) {
	try {
		em.merge(pelicula);
		return true;
	}catch (Exception e){
		e.printStackTrace();
		return false;
	}
		
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
		return  em.createNativeQuery("SELECT * from tie_pelicula order by pel_id asc", Pelicula.class).getResultList(); 
	}
	
	@SuppressWarnings("unchecked")
	public List<Pelicula> listMasComprado(int numeroRegistros){    
		return  em.createNativeQuery("SELECT * from tie_pelicula p order by p.pel_cantidad_venta desc limit "+numeroRegistros, Pelicula.class).getResultList(); 
	}
	
	/**
	 * Metodo que lista los objetos de esta clase guardados en
	 * la base de datos
	 * @return una lista con todos los resultados
	 */
	public List<Pelicula> listMasVotados(int numeroRegistros){    
		return  em.createNativeQuery("SELECT * from tie_pelicula order by pel_cantidad_voto desc limit "+numeroRegistros, Pelicula.class).getResultList(); 
	}
	
	
	
	
}
