package ec.edu.ups.vistaBean;
 
import java.awt.event.ActionEvent;
import java.io.File;
import java.sql.Connection;
import java.sql.DriverManager;
import java.util.ArrayList;
import java.util.Date;
import java.util.List; 

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean; 
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletResponse;

import ec.edu.ups.modelo.Carrito;
import ec.edu.ups.modelo.Categoria;
import ec.edu.ups.modelo.FacturaCabecera;
import ec.edu.ups.modelo.Pelicula;
import ec.edu.ups.modelo.Usuario;
import ec.edu.ups.negocioInterface.GestionTiendaLocal;
import net.sf.jasperreports.engine.JasperExportManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.util.JRLoader; 

@ManagedBean
@SessionScoped
public class GestionTiendaBean {

	@Inject
	private GestionTiendaLocal gl;
	
	
	private Pelicula pelicula;
	private Categoria categoria;
	private Usuario usuario;
	private Usuario usuarioLogin;
	
	 
	
	@PostConstruct
	public void init(){
		pelicula = new Pelicula();
		categoria = new Categoria();
		usuario = new Usuario(); 
	}
	
	
	 

	/**
	 * Metodo que permite obtener un objeto de tipo Pelicula
	 * @return objeto Pelicula
	 */
	public Pelicula getPelicula() {
		return pelicula;
	}


	/**
	 * Metodo que permite setear un objeto pelicula
	 * @param pelicula objeto a ser seteado
	 */
	public void setPelicula(Pelicula pelicula) {
		this.pelicula = pelicula;
	}


	/**
	 * Metodo que permite obtener una Categoria
	 * @return objeto Categoria
	 */
	public Categoria getCategoria() {
		return categoria;
	}
	
	/**
	 * Metodo que permite setear un objeto Categoria
	 * @param categoria objeto a ser seteado
	 */
	public void setCategoria(Categoria categoria) {
		this.categoria = categoria;
	}


	/**
	 * Metodo que permite obtener un objeto Usuario
	 * @return objeto Usuario
	 */
	public Usuario getUsuario() {
		return usuario;
	}
	
	/**
	 * Metodo que permite setear un objeto Usuario
	 * @param usuario metodo a setear
	 */
	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

	/**
	 * Metodo que permite obtener un objeto Usuario para Login
	 * @return objeto Usuario para Login
	 */
	public Usuario getUsuarioLogin() {
		return usuarioLogin;
	}

	/**
	 * Metodo que permite setear un objeto Usuario para Login
	 * @param usuarioLogin objeto a setear
	 */
	public void setUsuarioLogin(Usuario usuarioLogin) {
		this.usuarioLogin = usuarioLogin;
	}



	/*
	 * Para Crud Usuario
	 */ 
	/**
	 * Metodo que permite crear un objeto Usuario, setea datos
	 * iniciales que seran controlados por el paquete de negocio
	 * @return mensaje de como se proceso el metodo
	 */
	public String crearUsuario() {
		// TODO Auto-generated method stub
		usuario.setDineroGastado(0);
		usuario.setFechaRegistro(new Date());
		usuario.setListaCarrito(new ArrayList<Carrito>());
		usuario.setListaFacturaCabecera(new ArrayList<FacturaCabecera>());
		if(!gl.crearUsuario(usuario).contains("no")) {
			//limpiarUsuario();
			return "usuario creado";
		}
		return "usuario no creado";
	}
	
	/**
	 * Metodo que permite actualizar un objeto de tipo usuario
	 * @return true o false dependiendo de como se proceso el metodo
	 */
	public boolean updateUsuario() { 
	    
	    
		System.out.println("modificar: "+this.usuario);
		 
			 gl.updateUsuario(this.usuario); 

		 
		 
		 return true;
	}
	
	
	/**
	 * Metodo que permite remover un objeto usuario haciendo una 
	 * llamada al metodo de la capa de negocio
	 * @param cedula parametro clave para modificar el objeto
	 * @return mensaje si es que se proceso correctamente
	 */
	public boolean eliminarUsuario(String cedula) {
		// TODO Auto-generated method stub
		System.out.println("Eliminando usuario: " + cedula);
		return gl.eliminarUsuario(cedula);
	}

	/**
	 * Metodo que permite buscar y devolver un objeto de tipo Usuario mediente
	 * el parametro de la cedula desde el bean
	 * @param cedula parametro clave con el cual se buscara un objeto
	 * @return un objeto de tipo Usuario
	 */
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
	

	/**
	 * Metodo que permite obtener una lista de objetos de tipo Usuario
	 * @return una lista con todos los Usuarios existentes
	 */
	public List<Usuario> listarUsuarios() {
		return gl.getUsuarios(); 
	}
	
	/**
	 * 
	 * @return
	 */
	public List<Usuario> listarUsuarioMas() {
		return gl.getUsuariosMas(); 
	}
	

	
	/*
	 * Para Crud Pelicula
	 */
	/**
	 * Metodo que permite crear un objeto de tipo Pelicula desde el bean
	 * @param pelicula objeto a ser creado
	 * @return mensaje si se proceso o no correctamente
	 */
	public String crearPelicula(Pelicula pelicula) {
		// TODO Auto-generated method stub
		System.out.println("llega al bean pelicula crear: "+pelicula);
		this.pelicula = new Pelicula();
		pelicula.setCodigoPelicula(this.pelicula.getCodigoPelicula());
		if(!gl.crearPelicula(pelicula).contains("no")) {
			//limpiarPelicula();
			return "pelicula creado";
		}
		return "pelicula no creado";
	}

	/**
	 * Metodo que permite actualizar un objeto de tipo Pelicula 
	 * para el bean
	 * @param pelicula objeto a actualizarse
	 * @return mensaje si se proceso correctamente
	 */
	public boolean updatePelicula(Pelicula pelicula) {
		// TODO Auto-generated method stub
		System.out.println("Modificando pelicula: "+pelicula);
		return gl.updatePelicula(pelicula);
		//limpiarPelicula();
		
	}

	/**
	 * Metodo que permite eliminar un objeto de tipo pelicula desde
	 * el bean
	 * @param idPelicula parametro clave con el que se identifica al objeto
	 * @return mensaje si se proceso correctamente
	 */
	public boolean eliminarPelicula(int idPelicula) {
		// TODO Auto-generated method stub
		return gl.eliminarPelicula(idPelicula);
		
	}

	/**
	 * Metodo que permite devuelve una pelicula mediante el nombrePelicula
	 * @param nombrePelicula parametro por el cual se encontrara el objeto
	 * @return un objeto Pelicula
	 */
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

	/**
	 * Metodo que permite obtener todos los objetos existentes de tipo pelicula
	 * @param op para comprobar que sea la opcion que se escogio
	 * @return lista Pelicula
	 */
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
	
	/**
	 * Metodo que permite generar un reporte mediante JasperMetod en PDF
	 * 
	 */
	public void PDF() {
		
		Connection con = null;
        
        String url = "jdbc:postgresql://192.168.1.10:5432/tienda_appdis";
        try {
            Class.forName("org.postgresql.Driver");
            con =  DriverManager.getConnection(url,"postgres","postgres");
        } catch (Exception ex) {
            ex.printStackTrace();
        }
         
        
        JasperReport reporte = null;
        
        String path = "reportes/reporteMasVendidos.jasper"; 
      System.out.println("path real en linux: "+FacesContext.getCurrentInstance().getExternalContext().getRealPath("/"));
        
        try {
            reporte = (JasperReport)JRLoader.loadObject(new File(path));
            JasperPrint j = JasperFillManager.fillReport(path, null, con);//JasperFillManager.fillReport(path,null,con);
            
            HttpServletResponse httpresponse = (HttpServletResponse)FacesContext.getCurrentInstance().getExternalContext().getResponse();
            httpresponse.addHeader("Content-disposition", "attachment; filename=reporte.pdf");
            ServletOutputStream servletoutput = httpresponse.getOutputStream();
            JasperExportManager.exportReportToPdfStream(j,servletoutput);
            
            
            
        } catch (Exception ex) { 
        	ex.printStackTrace();
        } 
	}

	
	/*
	 * Para crud categoria
	 */
	/**
	 * Metodo que permite crear un objeto de tipo Categoria desde el Bean
	 * @param categoria objeto a ser creado
	 * @return mensaje si se proceso correctamente el metodo
	 */
	public String crearCategoria(Categoria categoria) {
		// TODO Auto-generated method stub
		categoria.setListaPeliculas(new ArrayList<Pelicula>());
		this.categoria = new Categoria();
		categoria.setIdCategoria(this.categoria.getIdCategoria());
		if(!gl.crearCategoria(categoria).contains("no")) {
			
			//limpiarCategoria();
			return "categoria creado";
		}
		return "categoria no creado";
	}

	/**
	 * Metodo que permite actualizar un objeto categoria desde el Bean
	 * @param categoria objeto a ser actualizado
	 * @return booleano si es que se proceso correctamente
	 */
	public boolean updateCategoria(Categoria categoria) {
		// TODO Auto-generated method stub
		gl.updateCategoria(categoria);
		limpiarCategoria();
		return true;
	}

	/**
	 * Metodo que permite eliminar un objeto categoria desde el Bean
	 * @param idCategoria parametro clave con el cual se identica al objeto
	 * @return mensaje si es que se proceso correctamente el metodo
	 */
	public boolean eliminarCategoria(int idCategoria) {
		// TODO Auto-generated method stub
		return gl.eliminarCategoria(idCategoria);
	}

	/**
	 * Metodo que permite encontrar un objeto categoria mediante su nombre
	 * @param nombreCategoria parametro con el cual buscara el metodo
	 * @return un objeto de tipo categoria en caso de que exista, caso contrario null
	 */
	public Categoria buscarCategoria(String nombreCategoria) {
		// TODO Auto-generated method stub
		System.out.println("Nombre categoria enviado: "+nombreCategoria);
		for(Categoria categoria: listarCategorias()) {
			if(categoria.getNombre().toLowerCase().trim().contains(nombreCategoria.toLowerCase().trim())) {
				System.out.println("Categoria encontrada: "+categoria.getNombre());
				this.categoria = categoria;
				return categoria;
			}
			System.out.println("buscando categoria...."+nombreCategoria);
		}
		return null;
		
	}
	
	/**
	 * Metodo que permite buscar una categoria mediante su clave principal
	 * @param idCategoria parametro clave con el cual se identificara el metodo deseado
	 * @return objeto categoria en caso de que exista, caso contrario null
	 */
	public Categoria buscarCategoria(int idCategoria) {
		// TODO Auto-generated method stub 
		for(Categoria categoria: listarCategorias()) {
			if(categoria.getIdCategoria()== idCategoria) {
				System.out.println("Categoria encontrada: "+categoria.getNombre());
				this.categoria = categoria;
				return categoria;
			} 
		}
		return null;
		
	}

	/**
	 * Metodo que devuelve una lista con todos los objetos existentes de tipo categoria
	 * @return un mensaje si se proceso correctamente el metodo
	 */
	public List<Categoria> listarCategorias() {
		// TODO Auto-generated method stub
		return gl.getCategorias();
	}

	/**
	 * Metodo que permite limpiar los campos para volver a ser usados
	 */
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
	
	/**
	 * Metodo que permite limpiar los campos para volver a ser usados
	 */
	public void limpiarPelicula() {
		try{
			 this.pelicula.setAnio(0);
			 this.pelicula.setCantidadVentas(0); 
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
	
	/**
	 * Metodo que permite limpiar los campos para volver a ser usados
	 */
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
	
	
	 
	 
	
/**
 * Metodo que permite el logueo del usuario si es que la informacion que recibe
 * es correcta	
 * @param user parametro usuario a ser comprobado con el existente en la bd
 * @param password user parametro usuario a ser comprobado con el existente en la bd
 * @return la pagina a la que se redigira en caso de que sea exitoso, o tambien en el caso de que no
 */
public String login(String user, String password) { 
		String resultado = gl.login(user, password);
		if (resultado.equalsIgnoreCase("Credenciales incorrectas"))
		 return "login.xhtml";
		System.out.println("resultado en bean de login:"+resultado);
		usuarioLogin = buscarUsuario(resultado.split(":")[0]);
		if(!resultado.split(":")[1].equalsIgnoreCase("admin")) {
			 
				try{
					 this.usuarioLogin.setApellido("");
					 this.usuarioLogin.setCedula("");
					 this.usuarioLogin.setContrasenia("");
					 this.usuarioLogin.setDineroGastado(0);
					 this.usuarioLogin.setDireccionUsuario("");
					 this.usuarioLogin.setEmail("");
					 this.usuarioLogin.setFechaNacimiento(new Date());
					 this.usuarioLogin.setFechaRegistro(new Date());
					 this.usuarioLogin.setListaCarrito(new ArrayList<Carrito>());
					 this.usuarioLogin.setListaFacturaCabecera(new ArrayList<FacturaCabecera>());
					 this.usuarioLogin.setNombre("");
					 this.usuarioLogin.setNumeroCompra(0);
					 this.usuarioLogin.setTelefono("");
					 this.usuarioLogin.setTipoUsuario("");
					 this.usuarioLogin.setUser("");
				return "login.xhtml";	 
				}catch(Exception e) {
						 
					 }
			
		}
		return  "index.xhtml";
	} 

	/**
	 * Metodo que permite listar los objetos Pelicula que mas han sido vendidos
	 * mostrando la cantidad de registros que se requiera por parametro
	 * @param numeroRegistros cantidad de registros a mostrarse
	 * @return lista de peliculas 
	 */
	public List<Pelicula> listPeliculaMasComprado(int numeroRegistros) {
		// TODO Auto-generated method stub
		return gl.listMasComprado(numeroRegistros);
	}
	
	/**
	 * Metodo que permite listar los objetos Pelicula que mas han sido votados
	 * mostrando la cantidad de registros que se requiera por parametro
	 * @param numeroRegistros cantidad de registros a mostrarse
	 * @return lista de peliculas 
	 */
	public List<Pelicula> listPeliculaMasVotado(int numeroRegistros) {
		// TODO Auto-generated method stub
		return gl.listMasVotado(numeroRegistros);
	}

 
}
