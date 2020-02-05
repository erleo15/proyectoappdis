package ec.edu.ups.vistaBean;
 
import java.sql.Array;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped; 
import javax.inject.Inject;
import javax.persistence.PersistenceException;

import ec.edu.ups.modelo.Carrito;
import ec.edu.ups.modelo.Categoria;
import ec.edu.ups.modelo.FacturaCabecera;
import ec.edu.ups.modelo.Pelicula;
import ec.edu.ups.modelo.Usuario;
import ec.edu.ups.negocioInterface.GestionTiendaLocal; 

@ManagedBean
@SessionScoped
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
	public String crearUsuario() {
		// TODO Auto-generated method stub
		usuario.setDineroGastado(0);
		usuario.setFechaRegistro(new Date());
		if(!gl.crearUsuario(usuario).contains("no")) {
			limpiarUsuario();
			return "usuario creado";
		}
		return "usuario no creado";
	}
 
	public boolean updateUsuario() { 
	    
	    
		System.out.println("modificar: "+this.usuario);
		 
			 gl.updateUsuario(this.usuario); 

		limpiarUsuario();
		 
		 return true;
	}
	
	
 
	public boolean eliminarUsuario(String cedula) {
		// TODO Auto-generated method stub
		System.out.println("Eliminando usuario: " + cedula);
		return gl.eliminarUsuario(cedula);
	}

	public Usuario buscarUsuario(String cedula) {
		for(Usuario usuario: listarUsuarios()) {
			if(usuario.getCedula().compareToIgnoreCase(cedula)==0) {
				System.out.println("Usuario encontrado en Bean "+usuario);
				this.usuario=usuario;
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
		System.out.println("llega al bean pelicula crear: "+pelicula);
		if(!gl.crearPelicula(pelicula).contains("no")) {
			limpiarPelicula();
			return "pelicula creado";
		}
		return "pelicula no creado";
	}

	
	public boolean updatePelicula(Pelicula pelicula) {
		// TODO Auto-generated method stub
		System.out.println("Modificando pelicula: "+pelicula);
		gl.updatePelicula(pelicula);
		limpiarPelicula();
		return true;
	}

	
	public boolean eliminarPelicula(int idPelicula) {
		// TODO Auto-generated method stub
		return gl.eliminarPelicula(idPelicula);
		
	}

	
	public Pelicula buscarPelicula(String nombrePelicula) {
		// TODO Auto-generated method stub
		for(Pelicula pelicula: listarPeliculas(1)) {
			if(pelicula.getNombre().toLowerCase().contains(nombrePelicula.toLowerCase())) {
				System.out.println("pelicula encontrada: "+pelicula);
				this.pelicula = pelicula;
				return pelicula;
			}
			System.out.println("buscando pelicula...."+nombrePelicula);
		}
		return null;
	}

	
	public List<Pelicula> listarPeliculas(int op) {
		// TODO Auto-generated method stub 
		if(op==1) {
			return gl.getPeliculas();
		}
		List<Pelicula> peliculas = gl.getPeliculas();
		for(int i = 0;i<peliculas.size();i++) {
			try {
			peliculas.get(i).setDescripcion(peliculas.get(i).getDescripcion().substring(0, 100));
			}catch(Exception e) {
				
			}
		}
		
		return peliculas;
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
			
			limpiarCategoria();
			return "categoria creado";
		}
		return "categoria no creado";
	}

	
	public boolean updateCategoria(Categoria categoria) {
		// TODO Auto-generated method stub
		gl.updateCategoria(categoria);
		limpiarCategoria();
		return true;
	}

	
	public boolean eliminarCategoria(int idCategoria) {
		// TODO Auto-generated method stub
		return gl.eliminarCategoria(idCategoria);
	}

	
	public Categoria buscarCategoria(String nombreCategoria) {
		// TODO Auto-generated method stub
		for(Categoria categoria: listarCategorias()) {
			if(categoria.getNombre().toLowerCase().contains(nombreCategoria.toLowerCase())) {
				System.out.println("pelicula encontrada: "+categoria);
				this.categoria = categoria;
				return categoria;
			}
			System.out.println("buscando pelicula...."+nombreCategoria);
		}
		return null;
		
	}

	
	public List<Categoria> listarCategorias() {
		// TODO Auto-generated method stub
		return gl.getCategorias();
	}

	
	
	
	
	
	
	
	
	public void limpiarUsuario() {
		try{
			 this.usuario.setApellido("");
			 this.usuario.setCedula("");
			 this.usuario.setContrasenia("");
			 this.usuario.setDineroGastado(0);
			 this.usuario.setDireccionUsuario("");
			 this.usuario.setEmail("");
			 this.usuario.setFechaNacimiento(new Date());
			 this.usuario.setFechaRegistro(new Date());
			 this.usuario.setListaCarrito(new ArrayList<Carrito>());
			 this.usuario.setListaFacturaCabecera(new ArrayList<FacturaCabecera>());
			 this.usuario.setNombre("");
			 this.usuario.setNumeroCompra(0);
			 this.usuario.setTelefono("");
			 this.usuario.setTipoUsuario("");
			 this.usuario.setUser("");
			 }catch(Exception e) {
				 
			 }
	}
	
	public void limpiarPelicula() {
		try{
			 this.pelicula.setAnio(0);
			 this.pelicula.setCantidadVentas(0);
			 this.pelicula.setCantidadVotos(0);
			 this.pelicula.setCodigoPelicula(0);
			 this.pelicula.setDescripcion("");
			 this.pelicula.setIdCategoria(0);
			 this.pelicula.setImagenHttp("");
			 this.pelicula.setNombre("");
			 this.pelicula.setPrecio(0.0);
			 this.pelicula.setStock(0);
			 }catch(Exception e) {
				 
			 }
	}
	
	
	public void limpiarCategoria() {
		try {
			this.categoria.setDescripcion("");
			this.categoria.setIdCategoria(0);
			this.categoria.setListaPeliculas(new ArrayList<Pelicula>());
			this.categoria.setNombre("");
		} catch (Exception e) {
			// TODO: handle exception
		}
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
