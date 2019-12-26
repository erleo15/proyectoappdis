package ec.edu.ups.datos;

import java.util.List;

import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.persistence.EntityManager;

import ec.edu.ups.modelo.TarjetaCredito;

@Stateless
public class TarjetaCreditoDAO {
 
	@Inject
	EntityManager em;
	
	/**
	 * Metodo que inserta un nuevo objeto de la clase 
	 * a la base
	 * @param tarjetaCredito representa la instancia en cuestion que 
	 * se va a ingresar
	 */
	public void insert(TarjetaCredito tarjetaCredito) {
		em.persist(tarjetaCredito);
	}
	
	/**
	 * Metodo que elimina un objeto de esta clase 
	 * en la base 
	 * @param tarjetaCredito Representa la la primary key 
	 * de la tabla para que elimine el objeto
	 */
	public void delete(TarjetaCredito tarjetaCredito) {
		em.remove(tarjetaCredito);
	}
	
	/**
	 * metodo que actualiza el objeto de esta clase en la BD
	 * 
	 * @param tarjetaCredito es la instancia de la clase en cuestiopn a administrar
	 */
	public void update(TarjetaCredito tarjetaCredito) {
	
		//em.remove(em.find(TarjetaCredito.class, idViejo));
		//em.persist(tarjetaCredito);
		
	}
	
	/**
	 * Metodo que busca un objeto de esa clase en la baseD
	 * @param numeroTarjeta es el valor de la primary key en la tabla
	 * @return retorna un objeto de la clase buscada
	 */
	public  TarjetaCredito find(int numeroTarjeta) {
		return em.find(TarjetaCredito.class, numeroTarjeta); 
	}
	
	/**
	 * Metodo que lista los objetos de esta clase guardados en
	 * la base de datos
	 * @return una lista con todos los resultados
	 */
	public List<TarjetaCredito> list(){    
		return  em.createQuery("SELECT c from tie_usuario c", TarjetaCredito.class).getResultList(); 
	}
}
