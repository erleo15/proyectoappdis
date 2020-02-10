package ec.edu.ups.negocioInterface;

import java.awt.event.ActionEvent;
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
	/**
	 * Metodo que permite crear un objeto de tipo Usuario
	 * @param usuario Objeto de tipo Usuario
	 * @return un String si es que fue creado correctamente
	 * 		   el objeto
	 */
	public String crearUsuario(Usuario usuario);
	/**
	 * Metodo que permite actualizar un objeto de tipo Usuario
	 * @param usuario Objeto de tipo Usuario
	 * @return Objeto de tipo usuario actualizado
	 */
	public boolean updateUsuario(Usuario usuario);
	/**
	 * Metodo que permite eliminar un objeto de tipo Usuario
	 * @param cedula parametro recibido como clave para eliminar usuario
	 * @return true en caso de que se realizo correctamente
	 */
	public boolean eliminarUsuario(String cedula);
	/**
	 * Metodo que devuelve un objeto de tipo Usuario buscado mediante 
	 * un parametro cedula
	 * @param cedula clave por la que elimina el objeto
	 * @return true en caso de que se realizo correctamente
	 */
	public Usuario buscarUsuario(String cedula);
	/**
	 * Metodo que devuelve una lista de tipo Usuario
	 * @return una lista de tipo Usuario
	 */
	public List<Usuario> getUsuarios();
	
	
	/*
	 * Parte Para Crud Peliculas
	 */
	/**
	 * Metodo que permite insertar un objeto de tipo pelicula
	 * haciendo un llamado a una clase del paquete datos
	 * @param pelicula objeto que se recibe para su procesamiento
	 * @return un mensaje si es que se creo o no correctamente el objeto
	 */
	public String crearPelicula(Pelicula pelicula);
	/**
	 * Metodo que permite actualizar una un objeto de tipo Pelicula
	 *  haciendo un llamado a una clase del paquete datos
	 * @param pelicula objeto que recibe para su procesamiento
	 * @return true si es que se creo correctamente
	 */
	public boolean updatePelicula(Pelicula pelicula);
	/**
	 * Metodo que permite eliminar un objeto de tipo Pelicula haciendo un llamado
	 * a una clase del paquete datos
	 * @param idPelicula mediante este parametro clave se eliminara un objeto
	 * @return true si es que se realizo correctamente
	 */
	public boolean eliminarPelicula(int idPelicula);
	/**
	 * Metodo que permite buscar un objeto de tipo Pelicula en la base de datos
	 * @param idPelicula paramtro clave por el cual se busca al objeto
	 * @return tue si es que se realizo correctamente
	 */
	public Pelicula buscarPelicula(int idPelicula);
	/**
	 * Metodo que permite obtener una lista de objetos de tipo Peliculas
	 * @return lista de tipo Pelicula
	 */
	public List<Pelicula> getPeliculas(); 
	
	public List<Usuario> getUsuariosMas();
	
	
	/*
	 * Parte para crud Categoria
	 */
	/**
	 * Metodo que permite insertar un objeto de tipo Categoria de una clase
	 * en una base de datos
	 * @param categoria Objeto que sera insertado en la base de datos
	 * @return mensaje si se realizo correctamente la insercion
	 */
	public String crearCategoria(Categoria categoria);
	/**
	 * Metodo que permite actualizar un objeto de tipo Categoria de una clase
	 * en una base de datos
	 * @param categoria objeto que sera actualizado en la base de datos
	 * @return returna true si es que se realizo correctamente
	 */
	public boolean updateCategoria(Categoria categoria);
	/**
	 * Metodo que permite eliminar un objeto de tipo Categoria de una clase
	 * en una base de datos
	 * @param idCategoria objeto a ser eliminado
	 * @return true si es que se realizo correctamente
	 */
	public boolean eliminarCategoria(int idCategoria);
	/**
	 * Metodo que permite buscar un objeto de tipo Categoria de una clase
	 * en una base de datos
	 * @param idCategoria parametro clave por el que sera buscado el objeto
	 * @return objeto buscado de tipo Categoria
	 */
	public Categoria buscarCategoria(int idCategoria);
	/**
	 * Metodo que permite obtener una lista de objetos de tipo Categoria
	 * de una clase
	 * @return una lista de Categorias
	 */
	public List<Categoria> getCategorias();
	
	
	/*
	 * Parte para crud Carrito
	 */
	/**
	 * Metodo que permite crear un objeto de tipo Carrito
	 * @param carrito objeto ha crearse
	 * @return mensaje si es que se creo correctamente
	 */
	public String crearCarrito(Carrito carrito);
	/**
	 * Metodo que permite actualizar un objeto de tipo Carrito
	 * @param carrito objeto ha actualizarse
	 * @return true si es que se realizo correctamente
	 */
	public boolean updateCarrito(Carrito carrito);
	/**
	 * Metodo que permite eliminar un objeto de tipo Carrito
	 * @param idCarrito parametro clave por el que sera eliminado el objeto Carrito
	 * @return true si es que se realizo correctamente
	 */
	public boolean eliminarCarrito(int idCarrito);
	/**
	 * Metodo que permite encontrar un objeto de tipo Carrito de una clase
	 * mediante un parametro idCarrito
	 * @param idCarrito parametro clave por el cual se buscara al objeto
	 * @return un objeto encontrado
	 */
	public Carrito buscarCarrito(int idCarrito);
	/**
	 * Metodo que retorna una lista de objetos de tipo Carrito
	 * @return un objeto de tipo Carrito
	 */
	public List<Carrito> getCarritos();
	/**
	 * Metodo que permite obtener una lista de objetos de tipo Carrito 
	 * mediante la cedula del cliente
	 * @param cedulaUsuario parametro clave por el cual se busca un objeto Carrito
	 * @return una lista de tipo Carrito
	 */
	public List<Carrito> getCarritoXCedula(String cedulaUsuario);
	
	
	
	/*
	 * Parte para crud FacturaCabecera
	 */
	/**
	 * Metodo que permite crear un objeto de tipo FacturaCabecera
	 * @param facturaCabecera objeto que sera creado
	 * @return mensaje si es que se ejecuto correctamente
	 */
	public String crearFCabecera(FacturaCabecera facturaCabecera);
	/**
	 * Metodo que permite crear un objeto de tipo FacturaCabecera
	 * @param facturaCabecera objeto ha actualizarse
	 * @return true si es que se realizo correctamente
	 */
	public boolean updateFCabecera(FacturaCabecera facturaCabecera);
	/**
	 * Metodo que permite eliminar un objeto de tipo FacturaCabecera
	 * mediante su numero de factura
	 * @param numeroFactura parametro clave por el que se eliminara una factura
	 * @return true si es que se elimino correctamente
	 */
	public boolean eliminarFCabecera(int numeroFactura);
	/**
	 * Metodo que permite buscar un objeto de tipo FacturaCabecera
	 * mediante su numero de factura 
	 * @param numeroFactura parametro clave por el que se encontrara una factura
	 * @return un objeto de tipo FacturaCabecera
	 */
	public FacturaCabecera buscarFCabecera(int numeroFactura);
	/**
	 * Metodo que permite obtener una lista de tipo FacturaCabecera
	 * @return lista con las FacturaCabecerea existentes
	 */
	public List<FacturaCabecera> getFacturaCabeceras();
	
	
	
	/*
	 * Parte para crud FacturaDetalle
	 */
	/**
	 * Metodo que permite crear un objeto de tipo FacturaDetalle
	 * @param facturaDetalle objeto ha ser creado
	 * @return mensaje si es se creo correctamente
	 */
	public String crearFDetalle(FacturaDetalle facturaDetalle);
	/**
	 * Metodo que permite actualizar un objeto de tipo FacturaDEtalle
	 * @param facturaDetalle objeto ha actualizarse
	 * @return true si es que se ha creado correctamente
	 */
	public boolean updateFDetalle(FacturaDetalle facturaDetalle);
	/**
	 * Metodo que permite eliminar un objeto de tipo Factura Detalle mediante
	 * el numero la misma
	 * @param numeroDetalle parametro clave para eliminar FDetalle
	 * @return true si es que se realizo correctamente
	 */
	public boolean eliminarFDetalle(int numeroDetalle);
	/**
	 * Metodo que permite eliminar un objeto de tipo Factura Detalle mediante
	 * el numero la misma
	 * @param numeroDetalle parametro clave para buscar una FacturaDetalle
	 * @return objeto buscado de tipo FacturaDetalle
	 */
	public FacturaDetalle buscarFDetalle(int numeroDetalle);
	/**
	 * Permite obrener una lista de objetos de tipo FacturaDetalle
	 * @return
	 */
	public List<FacturaDetalle> getFacturaDetalles();
	
	
	
	/*
	 * Lo que va a revisar el capi
	 */
	/**
	 * Metodo que permite controlar que el usuario y la contrasena
	 * son correctos para permitir el logueo
	 * @param user parametro a ser comparado con el parametro de la bd
	 * @param password parametro a ser comparado con el parametro de la bd
	 * @return
	 */
	public String login(String user, String password);
	/**
	 * Metodo que permite agregar un objeto de tipo Producto al 
	 * objeto de tipo Carrito controlando si se anade por primera
	 * vez o se vuelve a agregar a un producto existente
	 * @param idPelicula parametro clave por el que se agregara el objeto
	 * @param cedula parametro clave por el que se agregara el objeto
	 * @return mensaje si es que se realizo correctamente
	 */
	public String addCarrito(int idPelicula, String cedula); 
	/**
	 * Metodo que permite realizar una compra o generar una factura 
	 * @param cedulaUsuario parametro necesario para procesar una compra
	 * @param direccionEnvio parametro necesario para procesar una compra
	 * @param numeroTarjeta parametro necesario para procesar una compra
	 * @return mensaje si es que se realizo correctamente
	 */
	public String realizarCompra(String cedulaUsuario, String direccionEnvio, 
			String numeroTarjeta);
	/**
	 * Metodo que retorna una lista de objetos de tipo peliculas con 
	 * mayor cantidad en ventas
	 * @param numeroRegistros cantidad de registros a obtenerse en la lista
	 * @return retorna lista de tipo pelicula
	 */
	public List<Pelicula> listMasComprado(int numeroRegistros);
	/**
	 * Metodo que retorna una lista de objetos de tipo peliculas con 
	 * mayor cantidad de votos
	 * @param numeroRegistros cantida de registros a obtenerse en la lista
	 * @return lista de tipo Pelicula
	 */
	public List<Pelicula> listMasVotado(int numeroRegistros);
	/**
	 * Metodo que permite anular un objeto de tipo FacturaCabecera
	 * devolviendo el stock de productos que se realizo en dicha 
	 * factura.
	 * @param numeroFactura parametro clave para anular la factura
	 * @return true si es que se proceso correctamente
	 */
	public boolean anularFactura(int numeroFactura);
	/**
	 * Metodo que retorna un objeto de tipo FacturaCabecera que se busca mediante
	 * el parametro de la cedula del Usuario
	 * @param cedulaUsuario parametro clave para devolver una factura
	 * @return lista de FacturaCabecera
	 */
	public List<FacturaCabecera> listarFCabXCedula(String cedulaUsuario);
	/**
	 * Metodo que mediante JasperReport permite generar un reporte que puede
	 * integrarse en una aplicacion web o movil de las peliculas que mas se
	 * han vendido
	 */
	public void generarReporte(); 
	/**
	 * Metodo que permite eliminar un objeto de tipo Voto que realizo un
	 * usuario
	 * @param idPelicula parametro necesario para remover un voto
	 * @param cedula parametro necesario para remover un voto
	 * @return true si es que se proceso correctamente
	 */
	public boolean removeVotoXidAndCedula(int idPelicula, String cedula );
	
	
}
