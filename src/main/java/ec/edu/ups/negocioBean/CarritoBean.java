package ec.edu.ups.negocioBean;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.inject.Inject;

import ec.edu.ups.datos.CarritoDAO;
import ec.edu.ups.modelo.Carrito;

@ManagedBean
@ViewScoped
public class CarritoBean {

	private Carrito carrito;
	
	@Inject
	private CarritoDAO carritoDAO;
	
	@PostConstruct
	public void init() {
		carrito = new Carrito();
	}
}
