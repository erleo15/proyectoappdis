package ec.edu.ups.negocioBean;


import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.inject.Inject;


import ec.edu.ups.datos.UsuarioDAO;
import ec.edu.ups.modelo.Usuario;

@ManagedBean
@ViewScoped
public class UsuarioBean {

	private Usuario usuario;
	
	@Inject
	private UsuarioDAO usuarioDAO;
	
	@PostConstruct//init
	public void init() {
		usuario = new Usuario();
	}
	
	public String guardarUsuario() {
		usuarioDAO.insert(usuario);
		return null;
	}
	
	public String eliminarUsuario() {
		usuarioDAO.delete(usuario);
		return null;
	}
	
	public String actualizarUsuario() {
		usuarioDAO.update(usuario.getCedula(),usuario);
		return null;
	}
	
	public String buscarUsuario() {
		usuario = usuarioDAO.find(usuario.getCedula());
		return null;
	}
	
	public String listarUsuario() {
		return null;
	}
}
