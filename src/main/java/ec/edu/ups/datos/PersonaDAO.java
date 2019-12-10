package ec.edu.ups.datos;

import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.persistence.EntityManager;

import ec.edu.ups.modelo.Persona;

@Stateless
public class PersonaDAO {

	@Inject
	private EntityManager em;
	
	public void insert(Persona persona) {
		em.persist(persona);
	}
	
	public void delete(Persona persona) {
		em.remove(persona);
	}
	
	public void update(String cedulaAnterior,Persona persona) {
	
		em.remove(em.find(Persona.class, cedulaAnterior));
		em.persist(persona);
		
	}
	
	public  Persona find(String cedula) {
		em.find(Persona.class, cedula);
		return null;
	}
}
