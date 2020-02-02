package ec.edu.ups.negocioInterface;

import java.util.List;

import javax.ejb.Remote;

import ec.edu.ups.modelo.Carrito;
import ec.edu.ups.modelo.Categoria;
import ec.edu.ups.modelo.FacturaCabecera;
import ec.edu.ups.modelo.FacturaDetalle;
import ec.edu.ups.modelo.Pelicula;
import ec.edu.ups.modelo.Usuario;

@Remote
public interface GestionTiendaRemote {

	/*
	 * Parte Para Crud Usuario
	 */
	public String crearUsuario(Usuario usuario);
	public boolean updateUsuario(Usuario usuario);
	public boolean eliminarUsuario(String cedula);
	public Usuario buscarUsuario(String cedula);
	public List<Usuario> getUsuarios();
	
	
	/*
	 * Parte Para Crud Peliculas
	 */
	public String crearPelicula(Pelicula pelicula);
	public boolean updatePelicula(Pelicula pelicula);
	public boolean eliminarPelicula(int idPelicula);
	public Pelicula buscarPelicula(int idPelicula);
	public List<Pelicula> getPeliculas(); 
	
	
	/*
	 * Parte para crud Categoria
	 */
	public String crearCategoria(Categoria categoria);
	public boolean updateCategoria(Categoria categoria);
	public boolean eliminarCategoria(int idCategoria);
	public Categoria buscarCategoria(int idCategoria);
	public List<Categoria> getCategorias();
	
	
	/*
	 * Parte para crud Carrito
	 */
	public String crearCarrito(Carrito carrito);
	public boolean updateCarrito(Carrito carrito);
	public boolean eliminarCarrito(int idCarrito);
	public Carrito buscarCarrito(int idCarrito);
	public List<Carrito> getCarritos();
	public List<Carrito> getCarritoXCedula(String cedulaUsuario);
	
	
	
	/*
	 * Parte para crud FacturaCabecera
	 */
	public String crearFCabecera(FacturaCabecera facturaCabecera);
	public boolean updateFCabecera(FacturaCabecera facturaCabecera);
	public boolean eliminarFCabecera(int numeroFactura);
	public FacturaCabecera buscarFCabecera(int numeroFactura);
	public List<FacturaCabecera> getFacturaCabeceras();
	
	
	
	/*
	 * Parte para crud FacturaDetalle
	 */
	public String crearFDetalle(FacturaDetalle facturaDetalle);
	public boolean updateFDetalle(FacturaDetalle facturaDetalle);
	public boolean eliminarFDetalle(int numeroDetalle);
	public FacturaDetalle buscarFDetalle(int numeroDetalle);
	public List<FacturaDetalle> getFacturaDetalles();
	
	
	
	/*
	 * Lo que va a revisar el capi
	 */
	public String login(String user, String password);
	public String addCarrito(int idPelicula, String cedula); 
	public String realizarCompra(String cedulaUsuario, String direccionEnvio, 
			String numeroTarjeta);
	public List<Pelicula> peliculasMasVendidas();
	public boolean anularFactura(int numeroFactura);
	public List<FacturaCabecera> listarFCabXCedula(String cedulaUsuario);
	public void generarReporte() ;
	
}
