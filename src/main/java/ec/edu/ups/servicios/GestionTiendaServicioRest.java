package ec.edu.ups.servicios;




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
import ec.edu.ups.negocioInterface.GestionTiendaLocal; 

@Path("/servicios")
public class GestionTiendaServicioRest {

	@Inject
	private GestionTiendaLocal gl;
	
	@POST
	@Consumes("application/json")
	@Produces("application/json")
	@Path("realizarCompra")
	public String realizarCompra(String parametro)  {
		System.out.println("paramtreooooo"+ parametro);
		String cedulaUsuario = parametro.split(":")[2].replaceAll("\"", "").trim();
		String direccionEnvio = parametro.split(":")[3]; 
		String numeroTarjeta = parametro.split(":")[4]; 
		System.out.println(parametro+" en el servicio post");
		
		 return gl.realizarCompra(cedulaUsuario, direccionEnvio, numeroTarjeta);
	}
	
	
	@POST
	@Consumes("application/json")
	@Produces("application/json")
	@Path("addCarrito")
	public String addCarrito(String parametro) {//:1:0100500719:
		//System.out.println("addcarrito= "+parametro.split(":")[2].replaceAll("\"", "").trim()+"|"+parametro.split(":")[3]);
		int idPelicula = Integer.parseInt(parametro.split(":")[2].replaceAll("\"", "").trim());
		String cedula = parametro.split(":")[3];
		System.out.println(parametro + " Llegado a adcarritoServicioRest");
		return gl.addCarrito(idPelicula, cedula);
	}
	
	
	@POST
	@Consumes("application/json")
	@Produces("application/json")
	@Path("removeCarrito")
	public String removeCarrito(String parametro) {
		int idPelicula = Integer.parseInt(parametro.split(":")[2].replaceAll("\"", "").trim());
		String cedula = parametro.split(":")[3];
		for(Carrito carrito : gl.getCarritos()) {
			if(carrito.getCedulaUsuario().compareToIgnoreCase(cedula)==0 &&
				carrito.getIdPelicula() == idPelicula	
			   ) {
				if(gl.eliminarCarrito(carrito.getIdCarrito())) 
					return "Se elimino un carrito";
				else
					return "No se elimino el carrito";
			}
		}
		return "No se encontro el carrito";
	}
	
	
	
	
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
				carrito.getIdPelicula() == idPelicula	
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
	
	
	
	@GET
	//@Consumes("application/json")
	@Produces("application/json")
	@Path("getCarritoXCedula")
	public List<Carrito> listarCarritoXCedula(@QueryParam("parametro") String parametro)  {
		String cedulaUsuario = parametro.split(":")[2].replaceAll("\"", "").trim(); 
		
		return gl.getCarritoXCedula(cedulaUsuario);
	}
	
	
	@POST
	@Consumes("application/json")
	@Produces("application/json")
	@Path("anularFactura")
	public String anularFactura(String parametro)  {
		int numeroFactura = Integer.parseInt(parametro.split(":")[2].replaceAll("\"", "").trim());  
		return gl.anularFactura(numeroFactura)?"se anulo la factura": "no se anulo la factura";
		
	}
	
	
	@POST 
	@Consumes("application/json")
	@Produces("application/json")
	@Path("login")
	public String login(String parametro)  {
		System.out.println("parametro login==>"+parametro);
		String user = parametro.split(":")[2].replaceAll("\"", "").trim();
		String password = parametro.split(":")[3].replaceAll("\"", "").trim();
		return gl.login(user, password); 
	}
	
	@GET
	//@Consumes("application/json")
	@Produces("application/json")
	@Path("getComprasXCedula")
	public List<FacturaCabecera> listarFCabXCedula(@QueryParam("parametro") String parametro)  {
		String cedulaUsuario = parametro.split(":")[2].replaceAll("\"", "").trim();  
		return gl.listarFCabXCedula(cedulaUsuario);
	}
	
	
	@GET
	//@Consumes("application/json")
	@Produces("application/json")
	@Path("getPeliculas")
	public List<Pelicula> listarPeliculas()  {
		return gl.getPeliculas();
	}

	
	@GET 
	@Produces("application/json")
	@Path("getUsuarios")
	public List<Usuario> getUsuarios() { 
		return gl.getUsuarios();
	}
	
	
	@GET
	//@Consumes("application/json")
	@Produces("application/json")
	@Path("getPelicula")
	public String getPelicula(@QueryParam("id") String id)  {
		int idp = Integer.parseInt(id.split(":")[2].replaceAll("\"", "").trim()); 
		return gl.buscarPelicula(Integer.parseInt(idp+"")).getNombre(); 
	}
	
	/*public class Respuesta {
		
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
	}*/
	
	
}
