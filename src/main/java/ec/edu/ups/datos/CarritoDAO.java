package ec.edu.ups.datos;

import java.util.ArrayList;
import java.util.List;

import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.Query;

import ec.edu.ups.modelo.Carrito;

/**
 * Clase para administrar el carrito en la base de datos
 * @author erleo15
 *
 */
@Stateless
public class CarritoDAO {
	//hola

	@Inject
	private EntityManager em;
	/**
	 * metodo que inserta el objeto de esta clase en la base
	 * 
	 * @param objeto es la instancia de la clase en cuestiopn a administrar
	 */
	public boolean insert(Carrito carrito) {
		try {
			em.persist(carrito);
			return true;
		}catch(Exception e){
			e.printStackTrace();
		}
		return false;
	}
	
	/**
	 * metodo que actualiza el objeto de esta clase en la BD
	 * 
	 * @param id es la instancia de la clase en cuestiopn a administrar
	 */
	public boolean actualizar(Carrito carrito) {
		try{
			em.merge(carrito);
			return true;
		}catch(Exception e) {
			e.printStackTrace();
			return false;
		}
	}
	
	/**
	 * Metodo que busca un
	 * @param id es la instancia de la clase en cuestiopn a administrar
	 * @return retorna un objeto a la clase
	 */
	public Carrito find(int id ) { 
		return em.find(Carrito.class, id);
	}
	
	/**
	 * Metodo que lista los objetos de esta clase guardados en
	 * la base de datos
	 * @return una lista con todos los resultados
	 */
	public List<Carrito> getCarritos(){
		return em.createQuery("SELECT c from Carrito c", Carrito.class).getResultList();
	}
	
	public boolean remove(int idCarrito ) { 
		try {
		em.remove(find(idCarrito));
		return true;
		}catch(Exception e) {
			e.printStackTrace();
			return false;
		}
	}
	
	public int getLastIdCarrito() {
		String jpql = "Select MAX(e.idCarrito) from Carrito e";
		Query q = em.createQuery(jpql, Integer.class);
		return (int) q.getSingleResult();
	}
	
	public List<Carrito> getCarritoXCedula (String cedulaUsuario) {
		List<Carrito> lista = new ArrayList<Carrito>();
		
		for(Carrito carrito: getCarritos()) {
			if(carrito.getCedulaUsuario().compareTo(cedulaUsuario)==0) {
				lista.add(carrito);
			}
		}
		return  lista ;
	}
	
}
