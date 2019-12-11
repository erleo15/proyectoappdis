package ec.edu.ups.negocioBean;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.inject.Inject;

import ec.edu.ups.datos.FacturaDetalleDAO;
import ec.edu.ups.modelo.FacturaDetalle;

@ManagedBean
@ViewScoped
public class FacturaDetalleBean {

	private FacturaDetalle facturaDetalle;
	
	@Inject
	private FacturaDetalleDAO facturaDetalleDAO;
	
	@PostConstruct
	public void init() {
		facturaDetalle = new FacturaDetalle();
	}
}
