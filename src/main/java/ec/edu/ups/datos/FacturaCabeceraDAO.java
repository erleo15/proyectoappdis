package ec.edu.ups.datos;

import java.util.List;

import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.Query;
 
import ec.edu.ups.modelo.FacturaCabecera;

@Stateless
public class FacturaCabeceraDAO {

	@Inject
	private EntityManager em;
	/**
	 * metodo que inserta el objeto de esta clase en la base
	 * 
	 * @param objeto es la instancia de la clase en cuestiopn a administrar
	 */
	public boolean insert(FacturaCabecera facturaCabecera) {
		try {
			em.persist(facturaCabecera);
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
	public void actualizar(FacturaCabecera facturaCabecera) {
		em.merge(facturaCabecera);
	}
	
	/**
	 * Metodo que busca un
	 * @param id es la instancia de la clase en cuestiopn a administrar
	 * @return retorna un objeto a la clase
	 */
	public FacturaCabecera find(String numeroFactura ) {
		return em.find(FacturaCabecera.class, numeroFactura);
	}
	
	/**
	 * Metodo que lista los objetos de esta clase guardados en
	 * la base de datos
	 * @return una lista con todos los resultados
	 */
	public List<FacturaCabecera> list(){
		 
			return em.createQuery("SELECT c from FacturaCabecera c", FacturaCabecera.class).getResultList();
		}
		
	public String getLastNumeroCategoria() {
		String jpql = "Select MAX(e.numeroFactura) from FacturaCabecera e";
		Query q = em.createQuery(jpql, Integer.class);
		return  q.getSingleResult().toString();
	}
}
