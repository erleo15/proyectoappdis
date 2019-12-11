package ec.edu.ups.negocioBean;


import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.inject.Inject;
import javax.persistence.Query;

import ec.edu.ups.datos.UsuarioDAO;
import ec.edu.ups.modelo.Categoria;
import ec.edu.ups.modelo.Usuario;

@ManagedBean
@ViewScoped
public class UsuarioBean {

	private Usuario usuario;
	
	@Inject
	private UsuarioDAO usuarioDAO;
	
	@PostConstruct
	public void init() {
		usuario = new Usuario();
	}
	
	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}
	
	
	public String guardarUsuario() {
		usuarioDAO.insert(usuario);
		return "usuarios.xhtml";
	}
	
	public String eliminarUsuario(String cedula) { 
		usuarioDAO.delete(cedula);
		return "usuarios.xhtml";
	}
	
	public String actualizarUsuario() {
		usuarioDAO.update(usuario);
		return "usuarios.xhtml";
	}
	
	public Usuario buscarUsuario() {
		return usuarioDAO.find(usuario.getCedula()); 
	}
	
	public List<Usuario> listarUsuario() {   	
		return usuarioDAO.list();
	}

	
	
}
