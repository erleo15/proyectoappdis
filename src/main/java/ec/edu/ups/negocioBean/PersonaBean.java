package ec.edu.ups.negocioBean;

import javax.annotation.ManagedBean;
import javax.annotation.PostConstruct;
import javax.inject.Inject;

import ec.edu.ups.datos.PersonaDAO;
import ec.edu.ups.datos.UsuarioDAO;
import ec.edu.ups.modelo.Persona; 

@ManagedBean
public class PersonaBean {

	private Persona persona;
	
	@Inject
	private PersonaDAO personaDAO;

	@PostConstruct
	private void init() {
		persona = new Persona();
	}
	
	
	public String guardarPersona() {
		personaDAO.insert(persona);
		return null;
	}
	
}
