package ec.edu.ups.negocioBean;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.inject.Inject;

import ec.edu.ups.datos.PeliculaDAO;
import ec.edu.ups.modelo.Pelicula;

@ManagedBean
@ViewScoped
public class PeliculaBean {

private Pelicula pelicula; 
	
	@Inject
	private PeliculaDAO peliculaDAO;
	
	@PostConstruct
	public void init() {
		pelicula = new Pelicula();
	}
}
