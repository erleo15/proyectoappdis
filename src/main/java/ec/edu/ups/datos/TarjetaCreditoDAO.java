package ec.edu.ups.datos;

import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.persistence.EntityManager;

import ec.edu.ups.modelo.TarjetaCredito;

@Stateless
public class TarjetaCreditoDAO {

	//aqui agregue jejekse
	@Inject
	EntityManager em;
	
	public void insert(TarjetaCredito tarjetaCredito) {
		em.persist(tarjetaCredito);
	}
	
	public void delete(TarjetaCredito tarjetaCredito) {
		em.remove(tarjetaCredito);
	}
	
	public void update(String idViejo,TarjetaCredito tarjetaCredito) {
	
		em.remove(em.find(TarjetaCredito.class, idViejo));
		em.persist(tarjetaCredito);
		
	}
	
	public  TarjetaCredito find(int id) {
		em.find(TarjetaCredito.class, id);
		return null;
	}
}
