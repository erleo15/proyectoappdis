package ec.edu.ups.datos;

import java.util.List;

import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.Query;
 
import ec.edu.ups.modelo.FacturaDetalle;

@Stateless
public class FacturaDetalleDAO {

	@Inject
	private EntityManager em;
	
	/**
	 * metodo que inserta el objeto de esta clase en la base
	 * 
	 * @param objeto es la instancia de la clase en cuestiopn a administrar
	 */
	public boolean insert(FacturaDetalle facturaDetalle) {
		try {
			em.persist(facturaDetalle);
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
	public boolean actualizar(FacturaDetalle facturaDetalle) {
		try{
			em.merge(facturaDetalle);
			return true;
		}catch(Exception e) {
			e.printStackTrace();
			return false;
		}
	}
	
	/**
	 * Metodo que busca un objeto de la clase mediante un campo
	 * @param id es la instancia de la clase en cuestiopn a administrar
	 * @return retorna un objeto a la clase
	 */
	public FacturaDetalle find(int id ) {
		return em.find(FacturaDetalle.class, id);
	}
	
	/**
	 * metodo que actualiza el objeto de esta clase en la BD
	 * 
	 * @param id es la instancia de la clase en cuestiopn a administrar
	 */
	public boolean eliminar(int numeroDetalle) {
		try{
			em.merge(find(numeroDetalle));
			return true;
		}catch(Exception e) {
			e.printStackTrace();
			return false;
		}
	}
	
	/**
	 * Metodo que lista los objetos de esta clase guardados en
	 * la base de datos
	 * @return una lista con todos los resultados
	 */
	public List<FacturaDetalle> list(){
		return em.createQuery("SELECT c from FacturaDetalle c", FacturaDetalle.class).getResultList();

	}
	
	/**
	 * Metodo que devuelve el ultimo id de la clase almacenado en
	 * la base de datos
	 * @return
	 */
	public int getLastNumeroDetalle() {
		String jpql = "Select MAX(e.numFDetalle) from FacturaDetalle e";
		Query q = em.createQuery(jpql, Integer.class);
		return  (int)q.getSingleResult();
	}
	
	
}
