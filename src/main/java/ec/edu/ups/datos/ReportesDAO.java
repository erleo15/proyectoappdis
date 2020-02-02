package ec.edu.ups.datos;

import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.persistence.EntityManager;

@Stateless
public class ReportesDAO {

	@Inject
	private EntityManager em;
	
	
	
}
