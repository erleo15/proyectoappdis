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

/**
 * Clase que administra desde la vista 
 * la clase modelo en cuestion
 * @author erleo15
 *
 */
@ManagedBean
@ViewScoped
public class UsuarioBean {

	private Usuario usuario;
	
	@Inject
	private UsuarioDAO usuarioDAO;
	
	/**
	 * Metodo que inicializalos los objetos modelos
	 */
	@PostConstruct
	public void init() {
		usuario = new Usuario();
	}
	
	/**
	 * Metodo que obtiene obtiene el valor del objeto
	 * @return retorna un objeto
	 */
	public Usuario getUsuario() {
		return usuario;
	}

	/**
	 * Metodo que setea el atributo
	 * @param usuario valor a setear
	 */
	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}
	
	/**
	  * Metodo que guarda desde la vista 
	  * @return un cadena que redirecciona
	  */
	public String guardarUsuario() {
		usuarioDAO.insert(usuario);
		return "usuarios.xhtml";
	}
	
	/**
	 * Metodo que elimina un registro de esta clase
	 * modelo en la base de datos
	 * @param cedula el primary key de la tabla
	 * @return una cadena que redirecciona
	 */
	public String eliminarUsuario(String cedula) { 
		usuarioDAO.delete(cedula);
		return "usuarios.xhtml";
	}
	
	/**
	 * Metodo que actualiza un registro de esta clase modelo 
	 * en la base de datos
	 * @return una cadena que redirecciona
	 */
	public String actualizarUsuario() {
		usuarioDAO.update(usuario);
		return "usuarios.xhtml";
	}
	
	/**
	 * Metodo para buscar un objeto de esta
	 * clase en la base
	 * @return el objeto encontrado
	 */
	public Usuario buscarUsuario() {
		return usuarioDAO.find(usuario.getCedula()); 
	}
	
	/**
	 * Metodo que recupera todos los registros
	 * de esta clase modelo en la base
	 * @return lista de resultados de la 
	 * clase en cuestion
	 */
	public List<Usuario> listarUsuario() {   	
		return usuarioDAO.list();
	}

	public Usuario buscarUsuario(String cedula) {
		return usuarioDAO.find(cedula); 
	}

	public boolean guardarUsuario(Usuario usuario) {
		return usuarioDAO.insert(usuario); 
	}

	
	
}
