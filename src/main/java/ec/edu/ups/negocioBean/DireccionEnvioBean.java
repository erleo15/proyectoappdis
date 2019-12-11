package ec.edu.ups.negocioBean;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.inject.Inject;

import ec.edu.ups.datos.DireccionEnvioDAO;
import ec.edu.ups.modelo.DireccionEnvio;

@ManagedBean
@ViewScoped
public class DireccionEnvioBean {

	private DireccionEnvio direccionEnvio;
	
	@Inject
	private DireccionEnvioDAO direccionEnvioDAO;
	
	@PostConstruct
	public void init() {
		direccionEnvio = new DireccionEnvio();
	}
}
