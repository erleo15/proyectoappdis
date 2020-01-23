package ec.edu.ups.vistaBean;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.inject.Inject;

import ec.edu.ups.datos.FacturaCabeceraDAO;
import ec.edu.ups.modelo.FacturaCabecera;

/**
 * Clase que administra desde la vista 
 * la clase modelo en cuestion
 * @author erleo15
 *
 */
@ManagedBean
@ViewScoped
public class FacturaCabeceraBean {

	private FacturaCabecera facturaCabecera;
	
	@Inject
	private FacturaCabeceraDAO facturaCabeceraDAO;
	
	/**
	 * Metodo que inicializalos los objetos modelos
	 */
	@PostConstruct
	public void init() {
		facturaCabecera = new FacturaCabecera();
	}
}
