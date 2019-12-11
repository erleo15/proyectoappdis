package ec.edu.ups.negocioBean;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.inject.Inject;

import ec.edu.ups.datos.FacturaCabeceraDAO;
import ec.edu.ups.modelo.FacturaCabecera;

@ManagedBean
@ViewScoped
public class FacturaCabeceraBean {

	private FacturaCabecera facturaCabecera;
	
	@Inject
	private FacturaCabeceraDAO facturaCabeceraDAO;
	
	@PostConstruct
	public void init() {
		facturaCabecera = new FacturaCabecera();
	}
}
