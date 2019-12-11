package ec.edu.ups.negocioBean;

import java.util.List;

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
	
	
	public Pelicula getPelicula() {
		return pelicula;
	}

	public void setPelicula(Pelicula pelicula) {
		this.pelicula = pelicula;
	}
	
	
	public String guardarPelicula() {
		System.out.println("crear pelicula: "+pelicula);
		peliculaDAO.insert(pelicula);
		return null;
	}
	
	public String eliminarPelicula(int idPelicula) { 
		System.out.println(idPelicula+" vamo a ver");
		peliculaDAO.delete(idPelicula);
		return null;
	}
	
	public String actualizarPelicula() {
		peliculaDAO.update(pelicula);
		return null;
	}
	
	public Pelicula buscarPelicula() {
		return peliculaDAO.find(pelicula.getCodigoPelicula()); 
	}
	
	public List<Pelicula> listarPelicula() {   	
		return peliculaDAO.list();
	}

}
