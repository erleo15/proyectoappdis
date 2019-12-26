package ec.edu.ups.servicios;

import java.util.List;
import java.util.Random;

import javax.inject.Inject;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;

import ec.edu.ups.modelo.Categoria;
import ec.edu.ups.modelo.Pelicula;
import ec.edu.ups.modelo.Usuario;
import ec.edu.ups.negocioBean.CategoriaBean;
import ec.edu.ups.negocioBean.PeliculaBean;
import ec.edu.ups.negocioBean.UsuarioBean;

@Path("/servicios")
public class ServicioProducto {

	@Inject
	private PeliculaBean peliculaBean;
	@Inject
	private UsuarioBean usuarioBean;
	@Inject
	private CategoriaBean categoriaBean;
	
	//1
	/**
	 * Metodo para listar las peliculas registradas
	 * en la aplicacion
	 * @return los resultados obtenidos
	 */
	@GET
	@Path("/peliculaObtener")
	@Produces("application/json")
	public List<Pelicula> peliculas(){ 
		System.out.println(peliculaBean.listarPelicula());
		return peliculaBean.listarPelicula();
	}
	
	//2
		/**
		 * Metodo para obtener las categorias registradas
		 * @return lista con los resultados obtenidos
		 */
		@GET
		@Path("/categoriasObtener")
		@Produces("application/json")
		public List<Categoria> categorias(){ 
			System.out.println(categoriaBean.listarCategoria());
			return categoriaBean.listarCategoria();
		}
		
		//3
		/**
		 * Metodo que permite loguearse en 
		 * la aplicacion movil
		 * @param usuario
		 * @return
		 */
		@POST
		@Path("/loguear")
		@Produces("application/json")
		@Consumes("application/json")
		public Respuesta login(Usuario usuario) {
			Respuesta r = new Respuesta();
			 r.setCodigo(new Random().nextInt());
			Usuario aux = usuarioBean.buscarUsuario(usuario.getCedula());
			System.out.println("usuario:"+usuario+"    auxiliar:"+aux);
			if(aux.getContrasenia().compareTo(usuario.getContrasenia())==0) {
				r.setMensaje("Logueo exitoso");
				 r.setEstado(true);
				 return r;
			}
			r.setMensaje("Logueo no exitoso");
			r.setEstado(false);
			return r;
		}
		
		//4
		/**
		 * Metodo para insertar un usuario
		 * @param categoria
		 * @return
		 */
		@POST
		@Path("/insertarUsuario")
		@Produces("application/json")
		@Consumes("application/json")
		public Respuesta insertarUsuario(Usuario usuario) {
			
			Respuesta r = new Respuesta();
			r.setCodigo(new Random().nextInt());
			
			
				if(usuarioBean.guardarUsuario(usuario)) {
					r.setEstado(true);
					r.setMensaje("si se inserto categoria");
				}else {
					r.setEstado(false);
					r.setMensaje("no se inserto categoria");
				}
				
			 
			return r;
		}
		
		
	
	
	
	@GET
	@Path("/usuariosObtener")
	@Produces("application/json")
	public List<Usuario> usuarios(){ 
		System.out.println(usuarioBean.listarUsuario());
		return usuarioBean.listarUsuario();
	}
	
	
	@POST
	@Path("/insertarCategoria")
	@Produces("application/json")
	@Consumes("application/json")
	public Respuesta insertarPelicula(Categoria categoria) {
		
		Respuesta r = new Respuesta();
		r.setCodigo(new Random().nextInt());
		
		
			if(categoriaBean.guardarCategoria(categoria)) {
				r.setEstado(true);
				r.setMensaje("si se inserto categoria");
			}else {
				r.setEstado(false);
				r.setMensaje("no se inserto categoria");
			}
			
		 
		return r;
	}
	
	public class Respuesta {
		
		private int codigo;
		private boolean estado;
		private String mensaje;
		public int getCodigo() {
			return codigo;
		}
		public void setCodigo(int codigo) {
			this.codigo = codigo;
		}
		public boolean isEstado() {
			return estado;
		}
		public void setEstado(boolean estado) {
			this.estado = estado;
		}
		public String getMensaje() {
			return mensaje;
		}
		public void setMensaje(String mensaje) {
			this.mensaje = mensaje;
		}
		@Override
		public String toString() {
			return "Respuesta [codigo=" + codigo + ", estado=" + estado + ", mensaje=" + mensaje + "]";
		}
		
	}
	
}
