package ec.edu.ups.negocio;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.ejb.Stateless;
import javax.inject.Inject;

import ec.edu.ups.datos.CarritoDAO;
import ec.edu.ups.datos.CategoriaDAO;
import ec.edu.ups.datos.FacturaCabeceraDAO;
import ec.edu.ups.datos.FacturaDetalleDAO;
import ec.edu.ups.datos.PeliculaDAO;
import ec.edu.ups.datos.UsuarioDAO;
import ec.edu.ups.modelo.Carrito;
import ec.edu.ups.modelo.Categoria;
import ec.edu.ups.modelo.FacturaCabecera;
import ec.edu.ups.modelo.FacturaDetalle;
import ec.edu.ups.modelo.Pelicula;
import ec.edu.ups.modelo.Usuario;
import ec.edu.ups.negocioInterface.GestionTiendaLocal;
import ec.edu.ups.negocioInterface.GestionTiendaRemote;

@Stateless
public class GestionTiendaON implements GestionTiendaLocal, GestionTiendaRemote{

	@Inject
	private CarritoDAO carritoDAO;
	@Inject
	private CategoriaDAO categoriaDAO;
	@Inject
	private FacturaCabeceraDAO facturaCabeceraDAO;
	@Inject
	private FacturaDetalleDAO facturaDetalleDAO;
	@Inject
	private PeliculaDAO peliculaDAO;
	@Inject
	private UsuarioDAO usuarioDAO; 
	
	
	/*
	 * Para Crud Usuario
	 */
	@Override
	public String crearUsuario(Usuario usuario) {
		// TODO Auto-generated method stub
		if(usuarioDAO.insert(usuario)) {
			return "usuario creado";
		}
		return "usuario no creado";
	}

	@Override
	public boolean updateUsuario(Usuario usuario) {
		return usuarioDAO.update(usuario);
	}

	@Override
	public boolean eliminarUsuario(String cedula) {
		// TODO Auto-generated method stub
		return usuarioDAO.delete(cedula);
	}

	@Override
	public Usuario buscarUsuario(String cedula) {
		for(Usuario usuario: getUsuarios()) {
			if(usuario.getCedula().compareToIgnoreCase(cedula)==0) {
				System.out.println("Usuario encontrado en ON ");
				return usuario;
			}
		}
		return null;
	}

	@Override
	public List<Usuario> getUsuarios() {
		return getUsuariosLazy(usuarioDAO.list()); 
	}

	public List<Usuario> getUsuariosLazy(List<Usuario> usuarios) {
		for(Usuario u : usuarios) {
			for(FacturaCabecera fcab: u.getListaFacturaCabecera()) {
				
			}
		}
		return usuarios;
	}
	

	/*
	 * Para CRUD pelicula
	 */
	
	@Override
	public String crearPelicula(Pelicula pelicula) {
		// TODO Auto-generated method stub
		return peliculaDAO.insert(pelicula) ? "se creo la pelicula":"no se creo la pelicula";
		
	}

	@Override
	public boolean updatePelicula(Pelicula pelicula) {
		return peliculaDAO.update(pelicula);
	}

	@Override
	public boolean eliminarPelicula(int idPelicula) {
		// TODO Auto-generated method stub
		return peliculaDAO.delete(idPelicula);
	}

	@Override
	public Pelicula buscarPelicula(int idPelicula) {
		// TODO Auto-generated method stub
		return peliculaDAO.find(idPelicula);
	}

	@Override
	public List<Pelicula> getPeliculas() {
		// TODO Auto-generated method stub
		return peliculaDAO.list();
	}

	
	
	/*
	 * Para crear categoria
	 */
	
	@Override
	public String crearCategoria(Categoria categoria) {
		// TODO Auto-generated method stub
		return categoriaDAO.insert(categoria) ? "se creo la categoria":"no se creo la categoria";	
	}

	@Override
	public boolean updateCategoria(Categoria categoria) {
		// TODO Auto-generated method stub
		return categoriaDAO.update(categoria);
	}

	@Override
	public boolean eliminarCategoria(int idCategoria) {
		// TODO Auto-generated method stub
		return categoriaDAO.delete(idCategoria);
	}

	@Override
	public Categoria buscarCategoria(int idCategoria) {
		// TODO Auto-generated method stub
		return categoriaDAO.find(idCategoria);
	}

	@Override
	public List<Categoria> getCategorias() {
		// TODO Auto-generated method stub
		return categoriaDAO.list();
	}

	
	
	/*
	 * Para crear carrito
	 */
	
	@Override
	public String crearCarrito(Carrito carrito) {
		// TODO Auto-generated method stub
		return carritoDAO.insert(carrito) ? "se creo la carrito":"no se creo la carrito";	
	}

	@Override
	public boolean updateCarrito(Carrito carrito) {
		// TODO Auto-generated method stub
		return carritoDAO.actualizar(carrito);
	}

	@Override
	public boolean eliminarCarrito(int idCarrito) {
		// TODO Auto-generated method stub
		return carritoDAO.remove(idCarrito);
	}

	@Override
	public Carrito buscarCarrito(int idCarrito) {
		// TODO Auto-generated method stub
		return carritoDAO.find(idCarrito);
	}

	@Override
	public List<Carrito> getCarritos() {
		// TODO Auto-generated method stub
		return carritoDAO.getCarritos();
	}
	
	@Override
	public List<Carrito> getCarritoXCedula(String cedulaUsuario) {
		return carritoDAO.getCarritoXCedula(cedulaUsuario);	
	}

	
	/*
	 * Para Crud factura cabecera
	 */
	@Override
	public String crearFCabecera(FacturaCabecera facturaCabecera) {
		// TODO Auto-generated method stub
		return  facturaCabeceraDAO.insert(facturaCabecera) ? "se creo la factura": "no se creo la factura";
	}

	@Override
	public boolean updateFCabecera(FacturaCabecera facturaCabecera) {
		// TODO Auto-generated method stub
		return facturaCabeceraDAO.actualizar(facturaCabecera);
	}

	@Override
	public boolean eliminarFCabecera(int numeroFactura) {
		// TODO Auto-generated method stub
		return facturaCabeceraDAO.eliminar(numeroFactura);
	}

	@Override
	public FacturaCabecera buscarFCabecera(int numeroFactura) {
		// TODO Auto-generated method stub
		return facturaCabeceraDAO.find(numeroFactura);
	}

	@Override
	public List<FacturaCabecera> getFacturaCabeceras() {
		// TODO Auto-generated method stub
		return facturaCabeceraDAO.list();
	}

	
	/*
	 * Para CRUD Factura Detalle
	 */
	@Override
	public String crearFDetalle(FacturaDetalle facturaDetalle) {
		// TODO Auto-generated method stub
		return facturaDetalleDAO.insert(facturaDetalle)? "se creo detalle":"no se creo detalle";
	}

	@Override
	public boolean updateFDetalle(FacturaDetalle facturaDetalle) {
		// TODO Auto-generated method stub
		return facturaDetalleDAO.actualizar(facturaDetalle);
	}

	@Override
	public boolean eliminarFDetalle(int numeroDetalle) {
		// TODO Auto-generated method stub
		return facturaDetalleDAO.eliminar(numeroDetalle);
	}

	@Override
	public FacturaDetalle buscarFDetalle(int numeroDetalle) {
		// TODO Auto-generated method stub
		return facturaDetalleDAO.find(numeroDetalle);
	}

	@Override
	public List<FacturaDetalle> getFacturaDetalles() {
		// TODO Auto-generated method stub
		return facturaDetalleDAO.list();
	}
	
	
	
	
	
	
	
	/*
	 * Lo que va a revisar el capi
	 */
	
	
	@Override 
	public String login(String user, String password) {
		for(Usuario usuario: getUsuarios()) {
			if(usuario.getUser().compareToIgnoreCase(user)==0 && usuario.getContrasenia().compareTo(password)==0)
			{
				return usuario.getCedula();
			}
			 
		}
		return null;
	}
	
	
	
	
	@Override
	public String addCarrito(int idPelicula, String cedula) {
		// TODO Auto-generated method stub
		System.out.println(idPelicula+"--"+cedula+"--en GestionOnaddcarrito");
		Usuario u = buscarUsuario(cedula);
		Pelicula p = buscarPelicula(idPelicula);
		Carrito c = new Carrito();
		c.setCantidad(1);
		
		List<Carrito> lista = u.getListaCarrito();
		if(lista.isEmpty()) {
			c = new Carrito();
			c.setCantidad(1);
			c.setCedulaUsuario(cedula);
			c.setFecha(new Date());
			c.setIdPelicula(idPelicula); 
			c.setTotalCarrito(p.getPrecio());
			u.getListaCarrito().add(c);
			if(this.updateUsuario(u))
				return "Se anadio por primera vez al carrito";
			else
				return "No se anadio por primera vez al carrito";
		}
		
		
		for(Carrito car : lista) {
			if(car.getIdPelicula()==idPelicula) {
				
				car.setCantidad(car.getCantidad()+1); 
				car.setTotalCarrito(car.getCantidad()*p.getPrecio());
				this.updateCarrito(car);
				return "Se agrego cantidad +1";
				
			}
		}
		  
		if(!this.updateUsuario(u))
			return "No se agrego el producto al carrito"; 
		return "Se agrego el producto al carrito";
	}
	
	

	@Override
	public String realizarCompra(String cedulaUsuario, String direccionEnvio, 
			String numeroTarjeta) {
		
		System.out.println("Llegada de paramatros=\n"
				+ cedulaUsuario+":"+direccionEnvio+":"+numeroTarjeta);
		int numeroFactura = 1;
		List<Carrito> listaCarrito = getCarritoXCedula(cedulaUsuario);
		FacturaCabecera fcab = new FacturaCabecera();
		fcab.setCedulaUsuario(cedulaUsuario);
		fcab.setDireccionEnvio(direccionEnvio);
		fcab.setEstado("activa");
		fcab.setListaFacturaDetalle(new ArrayList<FacturaDetalle>());
		fcab.setNumeroTarjetaCredito(numeroTarjeta);
		fcab.setFecha(new Date());
		crearFCabecera(fcab);	
		numeroFactura = facturaCabeceraDAO.getLastNumeroFacturaCabecera();
		
		double dineroGastado = 0.0;
		FacturaDetalle fdet = new FacturaDetalle();
		Usuario u = buscarUsuario(cedulaUsuario);
		
		
		for(Carrito car : listaCarrito) {
			
			fdet.setCantidad(car.getCantidad());
			fdet.setNumeroFactura(numeroFactura);
			Pelicula pelicula = buscarPelicula(car.getIdPelicula());
			fdet.setPelicula(pelicula);
			dineroGastado += car.getTotalCarrito();//totalFacturaCabecera
			fdet.setTotalFDet(car.getTotalCarrito());
			fcab.getListaFacturaDetalle().add(fdet);
			if((pelicula.getStock()-car.getCantidad()) < 0) {
				if(eliminarFCabecera(numeroFactura)) {
					crearPelicula(pelicula);
					System.out.println("Se elimino factura: "+numeroFactura);
				}else{
					System.out.println("No se elimino la factura "+numeroFactura);
				}
				return "Stock insuficiente para Pelicula: "+pelicula;
			}
			pelicula.setStock(pelicula.getStock()-car.getCantidad());
			pelicula.setCantidadVentas(pelicula.getCantidadVentas()+1);
			if(updatePelicula(pelicula)) {
				System.out.println("Se actualizo stock de producto: "+pelicula);
			}
			if(eliminarCarrito(car.getIdCarrito())) {
				System.out.println("Eliminado carrito: "+car);
			}else {
				System.out.println("No eliminado carrito: "+car);
			}
		}
		
		
		fcab.setTotal(dineroGastado);
		
		if(!updateFCabecera(fcab)) {
			return "Ocurrio un error al generar la compra";
		}
		
		u.setDineroGastado(u.getDineroGastado()+dineroGastado);
		u.setNumeroCompra(u.getNumeroCompra()+1);
		this.updateUsuario(u);
		return "Se genero la compra exitosamente";
	}

	
	@Override
	public List<Pelicula> peliculasMasVendidas() {
		// TODO Auto-generated method stub
		return null;
	}
	

 
}
