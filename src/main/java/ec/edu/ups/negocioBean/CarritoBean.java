package ec.edu.ups.negocioBean;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.inject.Inject;

import ec.edu.ups.datos.CarritoDAO;
import ec.edu.ups.modelo.Carrito;

/**
 * Clase que administra desde la vista la clase modelo en cuestion
 * @author erleo15
 *
 */
@ManagedBean
@ViewScoped
public class CarritoBean {

	private Carrito carrito;
	
	@Inject
	private CarritoDAO carritoDAO;
	
	/**
	 * Metodo que inicializalos los objetos modelos
	 */
	@PostConstruct
	public void init() {
		carrito = new Carrito();
	}
}
