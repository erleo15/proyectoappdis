package ec.edu.ups.datos;

import java.util.List;

import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.Query;

import ec.edu.ups.modelo.Categoria;
import ec.edu.ups.modelo.Usuario;


@Stateless
public class UsuarioDAO {

	@Inject
	EntityManager em;
	
	/**
	 * Metodo que inserta un nuevo objeto de la clase 
	 * a la base
	 * @param usuario representa la instancia en cuestion que 
	 * se va a ingresar
	 */
	public boolean insert(Usuario usuario) {
		try {
			System.out.println("Guardadno usuario DAO: "+usuario);
		em.persist(usuario);
		return true;
		}catch(Exception e) {
			e.printStackTrace();
		}
		return false;
	}
	
	/**
	 * Metodo que elimina un objeto de esta clase 
	 * en la base 
	 * @param cedula Representa la la primary key 
	 * de la tabla para que elimine el objeto
	 */
	public void delete(String cedula) {
		em.remove(find(cedula));
	}
	
	/**
	 * metodo que actualiza el objeto de esta clase en la BD
	 * 
	 * @param usuario es la instancia de la clase en cuestiopn a administrar
	 */
	public void update(Usuario usuario) {
	
		em.remove(em.find(Usuario.class, usuario.getCedula()));
		em.persist(usuario);
		
	}
	
	/**
	 * Metodo que busca un objeto de esta clase en la base 
	 * de datos
	 * @param cedula es el valor de la primary key en la tabla
	 * @return retorna un objeto de la clase buscada
	 */
	public  Usuario find(String cedula) { 
		return em.find(Usuario.class, cedula); 
	}
	

	/**
	 * Metodo que lista los objetos de esta clase guardados en
	 * la base de datos
	 * @return una lista con todos los resultados
	 */
	public List<Usuario> list(){    
		return  em.createQuery("SELECT c from tie_usuario c", Usuario.class).getResultList(); 
	}

}
