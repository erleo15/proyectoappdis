package ec.edu.ups.negocioBean;

import javax.annotation.ManagedBean;
import javax.annotation.PostConstruct;
import javax.inject.Inject;


import ec.edu.ups.datos.UsuarioDAO;
import ec.edu.ups.modelo.Usuario;

@ManagedBean
public class UsuarioBean {

	private Usuario usuario;
	
	@Inject
	private UsuarioDAO usuarioDAO;
	
	@PostConstruct
	public void init() {
		usuario = new Usuario();
	}
	
	public String guardarUsuario() {
		usuarioDAO.insert(usuario);
		return null;
	}
}
