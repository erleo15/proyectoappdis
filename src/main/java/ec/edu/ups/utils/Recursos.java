package ec.edu.ups.utils;

import javax.enterprise.inject.Produces;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

public class Recursos {

	/**
	 * Interfaz utilizada para interactuar con el contexto de persistencia.
	 */
	@Produces
	@PersistenceContext
	private EntityManager em;
	
}