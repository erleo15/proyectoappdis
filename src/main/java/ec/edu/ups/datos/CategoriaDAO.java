package ec.edu.ups.datos;

import java.util.List;

import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.Query;

import ec.edu.ups.modelo.Categoria; 

@Stateless
public class CategoriaDAO {
	
	@Inject
	EntityManager em;
	
	/**
	 * Metodo que inserta un nuevo objeto de la clase 
	 * a la base
	 * @param categoria representa la instancia en cuestion que 
	 * se va a ingresar
	 */
	public boolean insert(Categoria categoria) {
	try {
		em.persist(categoria);
		return true;
	}catch(Exception e){
		e.printStackTrace();
	}
	return false;
	}
	
	/**
	 * Metodo que elimina un objeto de esta clase 
	 * en la base 
	 * @param idCategoria Representa la la primary key 
	 * de la tabla para que elimine el objeto
	 */
	public void delete(int idCategoria) {
		em.remove(find(idCategoria));
	}
	
	/**
	 * metodo que actualiza el objeto de esta clase en la BD
	 * 
	 * @param categoria es la instancia de la clase en cuestiopn a administrar
	 */
	public void update(Categoria categoria) {
	
		em.remove(em.find(Categoria.class, categoria.getIdCategoria()));
		em.persist(categoria);
		
	}
	
	/**
	 * Metodo que busca un objeto de esta clase en la base 
	 * de datos
	 * @param id es el valor de la primary key en la tabla
	 * @return retorna un objeto de la clase buscada
	 */
	public  Categoria find(int id) {
		return em.find(Categoria.class, id);
		
	}
	
	/**
	 * Metodo que lista los objetos de esta clase guardados en
	 * la base de datos
	 * @return una lista con todos los resultados
	 */
	public List<Categoria> list(){  
		return em.createQuery("SELECT c from tie_categoria c", Categoria.class).getResultList();
	}

}
