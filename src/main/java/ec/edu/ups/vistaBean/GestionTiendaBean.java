package ec.edu.ups.vistaBean;
 
import java.util.List;


import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.inject.Inject;
 
import ec.edu.ups.modelo.Categoria; 
import ec.edu.ups.modelo.Pelicula;
import ec.edu.ups.modelo.Usuario;
import ec.edu.ups.negocioInterface.GestionTiendaLocal; 

@ManagedBean
public class GestionTiendaBean {

	@Inject
	private GestionTiendaLocal gl;
	
	private Pelicula pelicula;
	private Categoria categoria;
	private Usuario usuario;
	
	@PostConstruct
	public void init(){
		pelicula = new Pelicula();
		categoria = new Categoria();
		usuario = new Usuario();
	}
	
	
	
	public Pelicula getPelicula() {
		return pelicula;
	}



	public void setPelicula(Pelicula pelicula) {
		this.pelicula = pelicula;
	}



	public Categoria getCategoria() {
		return categoria;
	}



	public void setCategoria(Categoria categoria) {
		this.categoria = categoria;
	}



	public Usuario getUsuario() {
		return usuario;
	}



	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}



	/*
	 * Para Crud Usuario
	 */ 
	public String crearUsuario(Usuario usuario) {
		// TODO Auto-generated method stub
		if(!gl.crearUsuario(usuario).contains("no")) {
			return "usuario creado";
		}
		return "usuario no creado";
	}
 
	public boolean updateUsuario(Usuario usuario) {
		return gl.updateUsuario(usuario);
	}
 
	public boolean eliminarUsuario(String cedula) {
		// TODO Auto-generated method stub
		return gl.eliminarUsuario(cedula);
	}

	public Usuario buscarUsuario(String cedula) {
		for(Usuario usuario: listarUsuarios()) {
			if(usuario.getCedula().compareToIgnoreCase(cedula)==0) {
				System.out.println("Usuario encontrado en ON ");
				return usuario;
			}
		}
		return null;
	}
	

	
	public List<Usuario> listarUsuarios() {
		return gl.getUsuarios(); 
	}

	
	/*
	 * Para Crud Pelicula
	 */
	
	public String crearPelicula(Pelicula pelicula) {
		// TODO Auto-generated method stub
		if(!gl.crearPelicula(pelicula).contains("no")) {
			return "pelicula creado";
		}
		return "pelicula no creado";
	}

	
	public boolean updatePelicula(Pelicula pelicula) {
		// TODO Auto-generated method stub
		return gl.updatePelicula(pelicula);
	}

	
	public boolean eliminarPelicula(int idPelicula) {
		// TODO Auto-generated method stub
		return gl.eliminarPelicula(idPelicula);
		
	}

	
	public Pelicula buscarPelicula(int idPelicula) {
		// TODO Auto-generated method stub
		for(Pelicula pelicula: listarPeliculas()) {
			if(pelicula.getCodigoPelicula() == idPelicula) {
				return pelicula;
			}
		}
		return null;
	}

	
	public List<Pelicula> listarPeliculas() {
		// TODO Auto-generated method stub
		return gl.getPeliculas();
	}
	
	public String generarReporte() {
		gl.generarReporte();
		return "/Users/erleo15/opt/wildfly-17.0.1.Final/bin/reporte.pdf";
	}

	
	/*
	 * Para crud categoria
	 */
	
	public String crearCategoria(Categoria categoria) {
		// TODO Auto-generated method stub
		if(!gl.crearCategoria(categoria).contains("no")) {
			return "categoria creado";
		}
		return "categoria no creado";
	}

	
	public boolean updateCategoria(Categoria categoria) {
		// TODO Auto-generated method stub
		return gl.updateCategoria(categoria);
	}

	
	public boolean eliminarCategoria(int idCategoria) {
		// TODO Auto-generated method stub
		return gl.eliminarCategoria(idCategoria);
	}

	
	public Categoria buscarCategoria(int idCategoria) {
		// TODO Auto-generated method stub
		return gl.buscarCategoria(idCategoria);
	}

	
	public List<Categoria> listarCategorias() {
		// TODO Auto-generated method stub
		return gl.getCategorias();
	}

	
	
	
	
	/*
	 * Lo que va a revisar el capi
	 */
	
	
	 
	public String login(String user, String password) {
		return gl.login(user, password);
	}
	
	

	
	public List<Pelicula> peliculasMasVendidas() {
		// TODO Auto-generated method stub
		return gl.peliculasMasVendidas();
	}

 
}
