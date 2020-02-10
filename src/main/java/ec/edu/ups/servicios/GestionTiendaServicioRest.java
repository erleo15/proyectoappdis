package ec.edu.ups.servicios;




import java.util.Date;
import java.util.List;

import javax.inject.Inject;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path; 
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;

import ec.edu.ups.modelo.Carrito;
import ec.edu.ups.modelo.FacturaCabecera;
import ec.edu.ups.modelo.Pelicula;
import ec.edu.ups.modelo.Usuario;
import ec.edu.ups.modelo.Voto;
import ec.edu.ups.negocioInterface.GestionTiendaLocal; 

@Path("/servicios")
public class GestionTiendaServicioRest {

	/**
	 * 
	 */
	@Inject
	private GestionTiendaLocal gl;
	
	/**
	 * Servicio que permite dar por finalizada una compra, separa los parametros por ":"
	 * y llama al metodo de negocio realizarCompra
	 * @param parametro string a ser separado por splits
	 * @return la respuesta a la llamada al metodo de negocio
	 */
	@POST
	@Consumes("application/json")
	@Produces("application/json")
	@Path("realizarCompra")
	public String realizarCompra(String parametro)  { 
		String cedulaUsuario = parametro.split(":")[2].replaceAll("\"", "").trim();
		String direccionEnvio = parametro.split(":")[3]; 
		String numeroTarjeta = parametro.split(":")[4]; 
		System.out.println(parametro+" en el servicio post");
		
		 return gl.realizarCompra(cedulaUsuario, direccionEnvio, numeroTarjeta);
	}
	
	/**
	 * Servicio que permite agregar al carrito de compras, el unico parametro se encuentra
	 * separado por ":" y llama al metodo de negocio agregar al carrito
	 * @param parametro String a ser separado por strings
	 * @return respuesta al metodo addCarrito
	 */
	@POST
	@Consumes("application/json")
	@Produces("application/json")
	@Path("addCarrito")
	public String addCarrito(String parametro) {//:1:0100500719:
		 int idPelicula = Integer.parseInt(parametro.split(":")[2].replaceAll("\"", "").trim());
		String cedula = parametro.split(":")[3];
		System.out.println(parametro + " Llegado a adcarritoServicioRest");
		return gl.addCarrito(idPelicula, cedula);
	}
	
	/**
	 * Servicio que permite remover el carrito de compras, separando los parametros por splits
	 * segun necesita el metodo de negocio, y hace una llamada al mismo
	 * @param parametro String a ser separado por splits
	 * @return mensaje si es que se realizo correctamente el proceso
	 */
	@POST
	@Consumes("application/json")
	@Produces("application/json")
	@Path("removeCarrito")
	public String removeCarrito(String parametro) {
		int idPelicula = Integer.parseInt(parametro.split(":")[2].replaceAll("\"", "").trim());
		String cedula = parametro.split(":")[3];
		for(Carrito carrito : gl.getCarritos()) {
			if(carrito.getCedulaUsuario().compareToIgnoreCase(cedula)==0 &&
				carrito.getPelicula().getCodigoPelicula() == idPelicula	
			   ) {
				if(gl.eliminarCarrito(carrito.getIdCarrito())) 
					return "Se elimino un carrito";
				else
					return "No se elimino el carrito";
			}
		}
		return "No se encontro el carrito";
	}
	
	
	
	/**
	 * Servicio que permite reducir un item en el Carrito de compras, separando el parametro
	 * por splits segun se necesite en el paquete de negocio, haciendo una llamada al mismo
	 * @param parametro String a ser separado por splits
	 * @return si es que se proceso correctamnete
	 */
	@POST
	@Consumes("application/json")
	@Produces("application/json")
	@Path("reduceCarrito")
	public String reduceCarrito(String parametro) {
		int idPelicula = Integer.parseInt(parametro.split(":")[2].replaceAll("\"", "").trim());
		Pelicula p = gl.buscarPelicula(idPelicula);
		String cedula = parametro.split(":")[3]; 
		for(Carrito carrito : gl.getCarritos()) {
			if(carrito.getCedulaUsuario().compareToIgnoreCase(cedula)==0 &&
				carrito.getPelicula().getCodigoPelicula() == idPelicula	
			   ) { 
				
				carrito.setCantidad(carrito.getCantidad()-1);
				carrito.setTotalCarrito(carrito.getTotalCarrito()-p.getPrecio());
				if(gl.updateCarrito(carrito)) 
					return "Se actualizo un carrito REST";
				else
					return "No se actualizo el carrito REST";
			}
		}
		return "No se encontro el carrito";
	}
	
	
	/**
	 * Servicio que permite listar un Carrito de Compras mediante un unico parametro cedula
	 * mediante splits, haciendo una llamada al metodo de negocio
	 * @param parametro String a ser separado por splits
	 * @return lista que contiene un carrito de compras
	 */
	@GET
	//@Consumes("application/json")
	@Produces("application/json")
	@Path("getCarritoXCedula")
	public List<Carrito> listarCarritoXCedula(@QueryParam("parametro") String parametro)  {
		System.out.println("Parametro recibido: "+parametro);
		String cedulaUsuario = parametro.split(":")[2].replaceAll("\"", "").trim(); 
		
		return gl.getCarritoXCedula(cedulaUsuario);
	}
	
	/**
	 * Servicio que hace una llamada al metodo de negocio para anular una factura(compra)
	 * con un unuco parametro como el numero de factura
	 * @param parametro String a ser separado por splits
	 * @return una respuesta si se proceso correctamente el servicio
	 */
	@POST
	@Consumes("application/json")
	@Produces("application/json")
	@Path("anularFactura")
	public String anularFactura(String parametro)  {
		int numeroFactura = Integer.parseInt(parametro.split(":")[2].replaceAll("\"", "").trim());  
		return gl.anularFactura(numeroFactura)?"se anulo la factura": "no se anulo la factura";
		
	}
	
	/**
	 * Servicio que hace una llamada al metodo de negocio que permite comprobar si
	 * los datos de usuario y contrasenia fueron ingresados correctamente
	 * @param parametro String a ser separado por splits, usuario y contrasenia
	 * @return si se proceso o no correctamente el servicio
	 */
	@POST 
	@Consumes("application/json")
	@Produces("application/json")
	@Path("login")
	public String login(String parametro)  {
		System.out.println("parametro login==>"+parametro);
		String user = parametro.split(":")[2].replaceAll("\"", "").trim();
		String password = parametro.split(":")[3].replaceAll("\"", "").trim();
		return gl.login(user, password).split(":")[0]; 
	}
	/**
	 * Servicio que haciendo una llamada al metodo de negocio permite listar
	 * facturaCabecera mediante el numero de la misma
	 * @param parametro String a ser separado por splits, numero de la factura
	 * @return lista con un objeto de tipo FacturaCabecera
	 */
	@GET
	//@Consumes("application/json")
	@Produces("application/json")
	@Path("getComprasXCedula")
	public List<FacturaCabecera> listarFCabXCedula(@QueryParam("parametro") String parametro)  {
		String cedulaUsuario = parametro.split(":")[2].replaceAll("\"", "").trim();  
		return gl.listarFCabXCedula(cedulaUsuario);
	}
	
	/**
	 * Servicio que permite listar los objetos de tipo Pelicula haciendo una
	 * llamada al metodo de negocio
	 * @return lista de objetos Pelicula existentes
	 */
	@GET
	//@Consumes("application/json")
	@Produces("application/json")
	@Path("getPeliculas")
	public List<Pelicula> listarPeliculas()  {
		return gl.getPeliculas();
	}
	
	
	@GET
	//@Consumes("application/json")
	@Produces("application/json")
	@Path("getUsuariosMasCompran")
	public List<Usuario> listarUsuarioMas()  {
		return gl.getUsuariosMas();
	}
	

	/**
	 * Servicio que permite listar los objetos de tipo Usuario haciendo una
	 * llamada al metodo de negocio
	 * @return lista de objetos Usuario existentes
	 */
	@GET 
	@Produces("application/json")
	@Path("getUsuarios")
	public List<Usuario> getUsuarios() { 
		return gl.getUsuarios();
	}
	
	/**
	 * Servicio que permite obtener un objeto Pelicula desde su clave 
	 * primaria(id) haciendo una llamada al metodo de negocio
	 * @param id String a ser separado por split, idPelicula
	 * @return mensaje si es que realizo correctamente el proceso
	 */
	@GET
	//@Consumes("application/json")
	@Produces("application/json")
	@Path("getPelicula")
	public Pelicula getPelicula(@QueryParam("id") String id)  {
		System.out.println(id);
		int idp = Integer.parseInt(id.split(":")[2].replaceAll("\"", "").trim()); 
		
		return gl.buscarPelicula(Integer.parseInt(idp+"")); 
	}
	
	/**
	 * Servicio que permite agregar un "like" a un objeto Pelicula haciendo
	 * una llamada al metodo de negocio
	 * @param parametro String a ser separado por splits, idPelicula cedulaUsuario
	 * @return mensaje si se proceso o no correctamente el servicio
	 */
	@POST
	@Consumes("application/json")
	@Produces("application/json")
	@Path("addLike")
	public String  addLike(String parametro) {
		System.out.println("paramtro en bean: "+parametro);
		String cedula = parametro.split(":")[2].replaceAll("\"", "").trim();
		int idPelicula = Integer.parseInt(parametro.split(":")[3].replaceAll("\"", "").trim());
		if(comprobarVoto(parametro)) {
			return "Ya tiene like";
		}
		Pelicula p = gl.buscarPelicula(idPelicula);
		Usuario u = gl.buscarUsuario(cedula);
		Voto v = new  Voto();
		v.setIdPelicula(idPelicula);
		v.setCedulaUsuario(cedula);
		p.getListaVoto().add(v);
		p.setCantidadVotos(p.getListaVoto().size()); 
		
		try {
		if(gl.updatePelicula(p)) { 
			System.out.println("se actualizo la pelicula para voto: "+p.getNombre()+p.getCantidadVotos());
			return "anadido like"; 
		} 
		}catch(Exception e) {
			
		}
		return "No se anadio like";
	}
	
	
	/**
	 * Servicio que permite quitar un "like" al objeto de tipo Pelicula mediante la
	 * cedula y el idPelicula haciendo una llamada al metodo de negocio
	 * @param parametro String a ser separado por splits, idPelicula cedulaUsuario
	 * @return mensaje si se proceso o no correctamente el servicio
	 */
	@POST
	@Consumes("application/json")
	@Produces("application/json")
	@Path("removeLike")
	public String  removeLike(String parametro) {
		System.out.println("paramtro en bean: "+parametro);
		String cedula = parametro.split(":")[2].replaceAll("\"", "").trim();
		int idPelicula = Integer.parseInt(parametro.split(":")[3].replaceAll("\"", "").trim());
		if(!comprobarVoto(parametro)) {
			return "Ya no tiene voto";
		}
		if(gl.removeVotoXidAndCedula(idPelicula, cedula)) {
			return "Se removio el voto: ";
		}else {
			return "No se removio el voto: ";
		}
		 
	}
	
	/**
	 * Servicio que permite comprobar si es que existe o no un "like" en el 
	 * objeto Pelicula mediante idPelicula y cedula del usuario haciendo una
	 * llamada al metodo de negocio
	 * @param parametro String a ser separado por splits, idPelicula cedulaUsuario
	 * @return mensaje si se proceso o no correctamente el servicio
	 */
	@POST
	@Consumes("application/json")
	@Produces("application/json")
	@Path("comprobarVoto")
	public boolean comprobarVoto(String parametro)  {
		System.out.println("paramtro comprobar voto en bean: "+parametro);
		String cedula = parametro.split(":")[2].replaceAll("\"", "").trim();
		int idPelicula = Integer.parseInt(parametro.split(":")[3].replaceAll("\"", "").trim());
		Pelicula p = gl.buscarPelicula(idPelicula);
		for(Voto v : p.getListaVoto()){
			if(v.getCedulaUsuario().equalsIgnoreCase(cedula)) {
				return true;
			}
		}
		return false;
	}
	
	/**
	 * Servicio que permite registrar un usuario en la base de datos haciendo
	 * una llamada al metodo de negocio
	 * @param usuario objeto a ser creado
	 * @return mensaje de el resultado de como se proceso el servicio
	 */
	@POST
	@Consumes("application/json")
	@Produces("application/json")
	@Path("agregarUsuario")
	public String agregarUsuario(Usuario usuario){ 
		usuario.setFechaRegistro(new Date());
		return gl.crearUsuario(usuario); 
	}
	
	
	/**
	 * Meoto que nos averigua el total de la factura a comprar
	 * @param parametro representa la cedula del cliente que requiere hacer la compra
	 * @return un valor double mayor a 0
	 */
	@POST
	@Consumes("application/json")
	@Produces("application/json")
	@Path("totalFactura")
	public double totalFactura(String parametro)  {
		System.out.println("paramtro comprobar voto en bean: "+parametro);
		String cedula = parametro.split(":")[2].replaceAll("\"", "").trim(); 
		double total = 0.0;
		for( Carrito car: gl.buscarUsuario(cedula).getListaCarrito()) {
			total += car.getTotalCarrito();
		} 
		return total;
	}
	
	
	
}
