package ec.edu.ups.negocio;

import java.awt.event.ActionEvent;
import java.io.File;
import java.io.FileOutputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.ejb.Stateless;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.collections.map.HashedMap;

import ec.edu.ups.datos.CarritoDAO;
import ec.edu.ups.datos.CategoriaDAO;
import ec.edu.ups.datos.FacturaCabeceraDAO;
import ec.edu.ups.datos.FacturaDetalleDAO;
import ec.edu.ups.datos.PeliculaDAO;
import ec.edu.ups.datos.UsuarioDAO;
import ec.edu.ups.datos.VotoDAO;
import ec.edu.ups.modelo.Carrito;
import ec.edu.ups.modelo.Categoria;
import ec.edu.ups.modelo.FacturaCabecera;
import ec.edu.ups.modelo.FacturaDetalle;
import ec.edu.ups.modelo.Pelicula;
import ec.edu.ups.modelo.Usuario;
import ec.edu.ups.negocioInterface.GestionTiendaLocal;
import ec.edu.ups.negocioInterface.GestionTiendaRemote;
import net.sf.jasperreports.engine.JasperExportManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.util.JRLoader; 

/**
 * 
 * @author erleo15
 *
 */
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
	@Inject
	private VotoDAO votoDAO;
	
	
	/*
	 * Para Crud Usuario
	 */
	/**
	 * Metodo que permite crear un objeto de tipo Usuario
	 */
	@Override
	public String crearUsuario(Usuario usuario) {
		// TODO Auto-generated method stub
		try {
			if(usuarioDAO.insert(usuario)) {
				return "usuario creado";
			}
			return "usuario no creado";
		} catch (Exception e) {
			//e.printStackTrace();
			return "usuario no creado por "+ e.getMessage(); 
			// TODO: handle exception
		}
		
	}

	/**
	 * Metodo que permite actualizar un objeto de tipo Usuario
	 */
	@Override
	public boolean updateUsuario(Usuario usuario) {
		return usuarioDAO.update(usuario);
	}

	/**
	 * Metodo que permite eliminar un objeto de tipo Usuario
	 */
	@Override
	public boolean eliminarUsuario(String cedula) {
		// TODO Auto-generated method stub
		return usuarioDAO.delete(cedula);
	}

	/**
	 * Metodo que devuelve un objeto de tipo Usuario buscado mediante 
	 * un parametro cedula
	 */
	@Override
	public Usuario buscarUsuario(String cedula) {
		for(Usuario usuario: getUsuarios()) {
			if(usuario.getCedula().compareToIgnoreCase(cedula)==0) {
				System.out.println("Usuario encontrado en ON "+usuario.getNombre());
				return usuario;
			}
		}
		return null;
	}

	/**
	 * Metodo que devuelve una lista de tipo Usuarios
	 */
	@Override
	public List<Usuario> getUsuarios() {
		return getUsuariosLazy(usuarioDAO.list()); 
	}
	
	/**
	 * 
	 */
	@Override
	public List<Usuario> getUsuariosMas() {
		return getUsuariosLazy(usuarioDAO.listmascompran()); 
	}
	
	

	/**
	 * Metodo que permite obtener una lista de usuarios
	 * @param usuarios lista de usuarios a buscar
	 * @return objeto
	 */
	@SuppressWarnings("unused")
	public List<Usuario> getUsuariosLazy(List<Usuario> usuarios) {
		List<Usuario> returnlist = new ArrayList<>(); 
		return usuarios;
		 
	}
	

	/*
	 * Para CRUD pelicula
	 */
	/**
	 * Metodo que permite insertar un objeto de tipo pelicula
	 * haciendo un llamado a una clase del paquete datos
	 */
	@Override
	public String crearPelicula(Pelicula pelicula) { 
		return peliculaDAO.insert(pelicula) ? "se creo la pelicula":"no se creo la pelicula";
		
	}

	/**
	 * Metodo que permite actualizar una un objeto de tipo Pelicula
	 *  haciendo un llamado a una clase del paquete datos
	 */
	@Override
	public boolean updatePelicula(Pelicula pelicula) {
		return peliculaDAO.update(pelicula);
	}

	/**
	 * Metodo que permite eliminar un objeto de tipo Pelicula haciendo un llamado
	 * a una clase del paquete datos
	 */
	@Override
	public boolean eliminarPelicula(int idPelicula) {
		// TODO Auto-generated method stub
		return peliculaDAO.delete(idPelicula);
	}
	
	/**
	 * Metodo que permite buscar un objeto de tipo Pelicula haciendo un llamado
	 * a una clase del paquete datos
	 */
	@Override
	public Pelicula buscarPelicula(int idPelicula) {
		// TODO Auto-generated method stub
		return peliculaDAO.find(idPelicula);
	}
	
	/**
	 * Metodo que permite obtener una lista de objetos de tipo Pelicula
	 */
	public List<Pelicula> getPeliculas(){
		// TODO Auto-generated method stub
		return peliculaDAO.list();
	}
	
	

	
	

	
	
	/*
	 * Para crear categoria
	 */
	
	/**
	 * Metodo que permite insertar un objeto de tipo Categoria de una clase
	 * en una base de datos
	 */
	@Override
	public String crearCategoria(Categoria categoria) {
		// TODO Auto-generated method stub
		return categoriaDAO.insert(categoria) ? "se creo la categoria":"no se creo la categoria";	
	}

	/**
	 * Metodo que permite actualizar un objeto de tipo Categoria de una clase
	 * en una base de datos
	 */
	@Override
	public boolean updateCategoria(Categoria categoria) {
		// TODO Auto-generated method stub
		return categoriaDAO.update(categoria);
	}
	
	/**
	 * Metodo que permite eliminar un objeto de tipo Categoria de una clase
	 * en una base de datos
	 */
	@Override
	public boolean eliminarCategoria(int idCategoria) {
		// TODO Auto-generated method stub
		return categoriaDAO.delete(idCategoria);
	}
	
	/**
	 * Metodo que permite buscar un objeto de tipo Categoria de una clase
	 * en una base de datos
	 */
	@Override
	public Categoria buscarCategoria(int idCategoria) {
		// TODO Auto-generated method stub
		return categoriaDAO.find(idCategoria);
	}
	
	/**
	 * Metodo que permite obtener una lista de objetos de tipo Categoria
	 * de una clase
	 */
	@Override
	public List<Categoria> getCategorias() {
		// TODO Auto-generated method stub
		return categoriaDAO.list();
	}

	
	
	/*
	 * Para crear carrito
	 */
	/**
	 * Metodo que permite crear un objeto de tipo Carrito
	 */
	@Override
	public String crearCarrito(Carrito carrito) {
		// TODO Auto-generated method stub
		return carritoDAO.insert(carrito) ? "se creo la carrito":"no se creo la carrito";	
	}

	/**
	 * Metodo que permite actualizar un objeto de tipo Carrito
	 */
	@Override
	public boolean updateCarrito(Carrito carrito) {
		// TODO Auto-generated method stub
		return carritoDAO.actualizar(carrito);
	}
	
	/**
	 * Metodo que permite eliminar un objeto de tipo Carrito
	 */
	@Override
	public boolean eliminarCarrito(int idCarrito) {
		// TODO Auto-generated method stub
		return carritoDAO.remove(idCarrito);
	}

	/**
	 * Metodo que permite encontrar un objeto de tipo Carrito de una clase
	 * mediante un parametro idCarrito
	 */
	@Override
	public Carrito buscarCarrito(int idCarrito) {
		// TODO Auto-generated method stub
		return carritoDAO.find(idCarrito);
	}

	/**
	 * Metodo que retorna una lista de objetos de tipo Carrito
	 */
	@Override
	public List<Carrito> getCarritos() {
		// TODO Auto-generated method stub
		return carritoDAO.getCarritos();
	}
	
	/**
	 * Metodo que permite obtener una lista de objetos de tipo Carrito 
	 * mediante la cedula del cliente
	 */
	@Override
	public List<Carrito> getCarritoXCedula(String cedulaUsuario) {
		System.out.println("Llega al carrito");
		return buscarUsuario(cedulaUsuario).getListaCarrito();	
	}

	
	/*
	 * Para Crud factura cabecera
	 */
	/**
	 * Metodo que permite crear un objeto de tipo FacturaCabecera
	 */
	@Override
	public String crearFCabecera(FacturaCabecera facturaCabecera) {
		// TODO Auto-generated method stub
		return  facturaCabeceraDAO.insert(facturaCabecera) ? "se creo la factura": "no se creo la factura";
	}

	/**
	 * Metodo que permite actualizar un objeto de tipo FacturaCabecera
	 */
	@Override
	public boolean updateFCabecera(FacturaCabecera facturaCabecera) {
		// TODO Auto-generated method stub
		return facturaCabeceraDAO.actualizar(facturaCabecera);
	}

	/**
	 * Metodo que permite eliminar un objeto de tipo FacturaCabecera
	 * mediante su numero de factura
	 */
	@Override
	public boolean eliminarFCabecera(int numeroFactura) {
		// TODO Auto-generated method stub 
		return facturaCabeceraDAO.eliminar(numeroFactura);
	}

	/**
	 * Metodo que permite buscar un objeto de tipo FacturaCabecera
	 * mediante su numero de factura 
	 */
	@Override
	public FacturaCabecera buscarFCabecera(int numeroFactura) {
		// TODO Auto-generated method stub
		return facturaCabeceraDAO.find(numeroFactura);
	}

	/**
	 * Metodo que permite obtener una lista de tipo FacturaCabecera
	 */
	@Override
	public List<FacturaCabecera> getFacturaCabeceras() {
		// TODO Auto-generated method stub
		return getFacturaCabecerasLazy(facturaCabeceraDAO.list());
	}
	
	/**
	 * Metodo que retorna una lista de tipo FacturaCabecera dependiendo
	 * controlando su FacturaDetalle
	 * @param facturaCabeceras lista FacturasCabeceras
	 * @return lista de tipoFacturaCabecera
	 */
	@SuppressWarnings("unused")
	public List<FacturaCabecera> getFacturaCabecerasLazy(List<FacturaCabecera> facturaCabeceras) {
		for(FacturaCabecera fcab : facturaCabeceras) {
			for(FacturaDetalle fdet: fcab.getListaFacturaDetalle()) {
				
			}
		}
		return facturaCabeceras;
	}

	
	/*
	 * Para CRUD Factura Detalle
	 */
	/**
	 * Metodo que permite crear un objeto de tipo FacturaDetalle
	 */
	@Override
	public String crearFDetalle(FacturaDetalle facturaDetalle) {
		// TODO Auto-generated method stub
		return facturaDetalleDAO.insert(facturaDetalle)? "se creo detalle":"no se creo detalle";
	}

	/**
	 * Metodo que permite actualizar un objeto de tipo FacturaDEtalle
	 */
	@Override
	public boolean updateFDetalle(FacturaDetalle facturaDetalle) {
		// TODO Auto-generated method stub
		return facturaDetalleDAO.actualizar(facturaDetalle);
	}

	/**
	 * Metodo que permite eliminar un objeto de tipo Factura Detalle mediante
	 * el numero la misma
	 */
	@Override
	public boolean eliminarFDetalle(int numeroDetalle) {
		// TODO Auto-generated method stub
		return facturaDetalleDAO.eliminar(numeroDetalle);
	}

	/**
	 * Metodo que permite eliminar un objeto de tipo Factura Detalle mediante
	 * el numero la misma
	 */
	@Override
	public FacturaDetalle buscarFDetalle(int numeroDetalle) {
		// TODO Auto-generated method stub
		return facturaDetalleDAO.find(numeroDetalle);
	}

	/**
	 * Permite obrener una lista de objetos de tipo FacturaDetalle
	 */
	@Override
	public List<FacturaDetalle> getFacturaDetalles() {
		// TODO Auto-generated method stub
		return facturaDetalleDAO.list();
	}
	
	
	
	
	
	
	
	/*
	 * Lo que va a revisar el capi
	 */
	
	/**
	 * Metodo que permite controlar que el usuario y la contrasena
	 * son correctos para permitir el logueo
	 */
	@Override 
	public String login(String user, String password) { 
		System.out.println(user+password);
		for(Usuario usuario: getUsuarios()) {
			if(usuario.getUser().compareToIgnoreCase(user)==0 && usuario.getContrasenia().compareTo(password)==0)
			{
				return usuario.getCedula()+":"+usuario.getTipoUsuario();
			}
			 
		}
		return "Credenciales incorrectas";
	}
	
	
	/**
	 * Metodo que permite agregar un objeto de tipo Producto al 
	 * objeto de tipo Carrito controlando si se anade por primera
	 * vez o se vuelve a agregar a un producto existente
	 */
	@Override
	public String addCarrito(int idPelicula, String cedula) {
		// TODO Auto-generated method stub 
		Usuario u = buscarUsuario(cedula);
		Pelicula p = buscarPelicula(idPelicula);
		Carrito c = new Carrito();
		boolean bandera = false;
		c.setCantidad(1);
		
		List<Carrito> lista = u.getListaCarrito();
		
		if(lista.isEmpty() ) {
			System.out.println("Primera vez anadiendo");
			c = new Carrito();
			c.setCantidad(1);
			c.setCedulaUsuario(cedula);
			c.setFecha(new Date());
			c.setPelicula(p);
			c.setTotalCarrito(p.getPrecio());
			u.getListaCarrito().add(c);
			
			
			if(this.updateUsuario(u))
				return "Se anadio por primera vez al carrito";
			else
				return "No se anadio por primera vez al carrito";
		}else {
			
			 for(Carrito car: lista) {
				 if(car.getCedulaUsuario().equalsIgnoreCase(cedula) &&
						 car.getPelicula().getCodigoPelicula()==idPelicula) {
					 bandera = true;
					 break;
				 }
			 }
			 
			 if(!bandera) {
				 System.out.println("Primera vez anadiendo");
					c = new Carrito();
					c.setCantidad(1);
					c.setCedulaUsuario(cedula);
					c.setFecha(new Date());
					c.setPelicula(p); 
					c.setTotalCarrito(p.getPrecio());
					u.getListaCarrito().add(c); 
					if(this.updateUsuario(u))
						return "Se anadio por primera vez al carrito";
					else
						return "No se anadio por primera vez al carrito";
			 }
		}
		
		
		for(Carrito car : lista) {
			if(car.getPelicula().getCodigoPelicula()==idPelicula) {
				
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
	
	

	/**
	 * Metodo que permite realizar una compra o generar una factura 
	 * 
	 */
	@Override
	public String realizarCompra(String cedulaUsuario, String direccionEnvio, 
			String numeroTarjeta) {
		 
		int numeroFactura = 1;
		List<Carrito> listaCarrito = buscarUsuario(cedulaUsuario).getListaCarrito(); 
		FacturaCabecera fcab = new FacturaCabecera();
		fcab.setCedulaUsuario(cedulaUsuario);
		fcab.setDireccionEnvio(direccionEnvio);
		fcab.setEstado("activa");
		fcab.setListaFacturaDetalle(new ArrayList<FacturaDetalle>());
		fcab.setNumeroTarjetaCredito(numeroTarjeta);
		fcab.setFecha(new Date());
		crearFCabecera(fcab);	
		numeroFactura = fcab.getNumeroFactura();
		double dineroGastado = 0.0;
		
		Usuario u = buscarUsuario(cedulaUsuario);
		
		
		for(Carrito car : listaCarrito) {
			FacturaDetalle fdet = new FacturaDetalle();
			fdet.setCantidad(car.getCantidad());
			fdet.setNumeroFactura(numeroFactura);
			Pelicula pelicula = buscarPelicula(car.getPelicula().getCodigoPelicula());
			
			dineroGastado += car.getTotalCarrito();//totalFacturaCabecera
			fdet.setTotalFDet(car.getTotalCarrito());
			
			if((pelicula.getStock()-car.getCantidad()) < 0) {
				if(eliminarFCabecera(numeroFactura)) {
					crearPelicula(pelicula);
					System.out.println("Se elimino factura: "+numeroFactura);
				}else{
					System.out.println("No se elimino la factura "+numeroFactura);
				}
				return "Stock insuficiente para Pelicula: "+pelicula.getNombre();
			}
			
			pelicula.setStock(pelicula.getStock()-car.getCantidad());
			pelicula.setCantidadVentas(pelicula.getCantidadVentas()+car.getCantidad());
			fdet.setPelicula(pelicula);
			fcab.getListaFacturaDetalle().add(fdet);
		} 
		fcab.setTotal(dineroGastado);
		System.out.println("factura cabecera a actualizar: "+fcab); 
		if(!updateFCabecera(fcab)) {
			return "Ocurrio un error al generar la compra";
		}
		
		u.setDineroGastado(u.getDineroGastado()+dineroGastado);
		u.setNumeroCompra(u.getNumeroCompra()+1);
		
		this.updateUsuario(u);
		for(Carrito car : listaCarrito) {
			if(eliminarCarrito(car.getIdCarrito())) {
				System.out.println("Eliminado carrito: "+car.getIdCarrito());
			}else {
				System.out.println("No eliminado carrito: "+car.getIdCarrito());
			}
		}
		return "Se genero la compra exitosamente";
	}

	/**
	 * Metodo que retorna una lista de objetos de tipo peliculas con 
	 * mayor cantidad en ventas
	 */
	@Override
	public List<Pelicula> listMasComprado(int numeroRegistros) {
		// TODO Auto-generated method stub
		 
		return peliculaDAO.listMasComprado(numeroRegistros);
	}
	
	/**
	 * Metodo que retorna una lista de objetos de tipo peliculas con 
	 * mayor cantidad de votos
	 */
	@Override
	public List<Pelicula> listMasVotado(int numeroRegistros) {
		// TODO Auto-generated method stub
		 
		return peliculaDAO.listMasVotados(numeroRegistros);
	}
	
	
	
	//implementados propios
	/**
	 * Metodo que permite anular un objeto de tipo FacturaCabecera
	 * devolviendo el stock de productos que se realizo en dicha 
	 * factura.
	 */
	@Override
	public boolean anularFactura(int numeroFactura)  {
		//int numeroFactura = Integer.parseInt(parametro.split(":")[2].replaceAll("\"", "").trim());  
		FacturaCabecera fcab = buscarFCabecera(numeroFactura);
		if(fcab==null || fcab.getEstado().compareTo("anulada")==0) 
			return false;
		Usuario u = buscarUsuario(fcab.getCedulaUsuario());
		//Usuario u = fcab.getUsuario();
		u.setDineroGastado(u.getDineroGastado()-fcab.getTotal());
		u.setNumeroCompra(u.getNumeroCompra()-1);
		fcab.setEstado("anulada");
	
		
		
		for(FacturaDetalle fdet : fcab.getListaFacturaDetalle()) {
			Pelicula p = fdet.getPelicula();
			p.setCantidadVentas(p.getCantidadVentas()-1);
			p.setStock(p.getStock()+fdet.getCantidad()); 
		}
		fcab.setCedulaUsuario(fcab.getCedulaUsuario());
		return updateFCabecera(fcab);
		
		//return gl.eliminarFCabecera(numeroFactura) ? "Se anulo la factura" : "No se anulo la factura";
	}

	/**
	 * Metodo que retorna un objeto de tipo FacturaCabecera que se busca mediante
	 * el parametro de la cedula del Usuario
	 */
	@Override
	public List<FacturaCabecera> listarFCabXCedula(String cedulaUsuario) {
		// TODO Auto-generated method stub
		List<FacturaCabecera> fcabs = new ArrayList<>();
		for(FacturaCabecera fcab: getFacturaCabeceras()) { 
			if(fcab.getCedulaUsuario().compareToIgnoreCase(cedulaUsuario)==0 && fcab.getEstado().compareTo("anulada")!=0) {
				fcabs.add(fcab);
			}
		}
		return fcabs;
	}
	
	/**
	 * Metodo que mediante JasperReport permite generar un reporte que puede
	 * integrarse en una aplicacion web o movil de las peliculas que mas se
	 * han vendido
	 */
	@SuppressWarnings("unused")
	@Override
	public void generarReporte() {
		
		Connection con = null;
        
        String url = "jdbc:postgresql://192.168.1.10:5432/tienda_appdis";
        try {
            Class.forName("org.postgresql.Driver");
            con =  DriverManager.getConnection(url,"postgres","postgres");
        } catch (Exception ex) {
            ex.printStackTrace();
        }
         
        
        JasperReport reporte = null;
        
        String relativePath = "reportes/reporteMasVendidos.jasper"; 
      System.out.println("path real en linux: "+FacesContext.getCurrentInstance().getExternalContext().getRealPath("/"));
        
        try {
            reporte = (JasperReport)JRLoader.loadObject(new File(relativePath));
            JasperPrint j = JasperFillManager.fillReport(relativePath, null, con);//JasperFillManager.fillReport(path,null,con);
            
            HttpServletResponse httpresponse = (HttpServletResponse)FacesContext.getCurrentInstance().getExternalContext().getResponse();
            httpresponse.addHeader("Content-disposition", "attachment; filename=reporte.pdf");
            ServletOutputStream servletoutput = httpresponse.getOutputStream();
            JasperExportManager.exportReportToPdfStream(j,servletoutput);
            
            
            
        } catch (Exception ex) { 
        	ex.printStackTrace();
        } 
		 
	}

	/**
	 * Metodo que permite eliminar un objeto de tipo Voto que realizo un
	 * usuario
	 */
	@Override
	public boolean removeVotoXidAndCedula(int idPelicula, String cedula) {
		// TODO Auto-generated method stub
		Pelicula p = buscarPelicula(idPelicula);
		p.setCantidadVotos(p.getCantidadVotos()-1);
		if(updatePelicula(p)) {
			if( !votoDAO.removeVotoXidAndCedula(idPelicula, cedula)) {
				 
				return !updatePelicula(p);
			}
		}
		return false;
		
	}

	
	

 
}
