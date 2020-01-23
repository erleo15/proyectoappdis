package ec.edu.ups.vistaBean;

import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.inject.Inject;

import ec.edu.ups.datos.PeliculaDAO; 
import ec.edu.ups.modelo.Pelicula; 

/**
 * Clase que administra desde la vista 
 * la clase modelo en cuestion
 * @author erleo15
 *
 */
@ManagedBean
@ViewScoped
public class PeliculaBean {

	private Pelicula pelicula; 
	
	@Inject
	private PeliculaDAO pl;
	
	/**
	 * Metodo que inicializalos los objetos modelos
	 */
	@PostConstruct
	public void init() {
		pelicula = new Pelicula();
	}
	
	/**
	 * Metodo que obtiene el atributo
	 * @return el valor del atributo
	 */
	public Pelicula getPelicula() {
		return pelicula;
	}

	/**
	 * Metodo que setea el atributo
	 * @param pelicula valor a setear
	 */
	public void setPelicula(Pelicula pelicula) {
		this.pelicula = pelicula;
	}
	
	/**
	  * Metodo que guarda desde la vista 
	  * @return un cadena que redirecciona
	  */
	public String guardarPelicula() {
		System.out.println("crear pelicula: "+pelicula);
		pl.insert(pelicula);
		return null;
	}
	
	/**
	 * Metodo que elimina un registro de esta clase
	 * modelo en la base de datos
	 * @param idPelicula el primary key de la tabla
	 * @return una cadena que redirecciona
	 */
	public String eliminarPelicula(int idPelicula) { 
		System.out.println(idPelicula+" vamo a ver");
		pl.delete(idPelicula);
		return null;
	}
	
	/**
	 * Metodo que actualiza un registro de esta clase modelo 
	 * en la base de datos
	 * @return una cadena que redirecciona
	 */
	public String actualizarPelicula() {
		pl.update(pelicula);
		return null;
	}
	
	/**
	 * Metodo para buscar un objeto de esta
	 * clase en la base
	 * @return el objeto encontrado
	 */
	public Pelicula buscarPelicula() {
		this.pelicula= pl.find(pelicula.getCodigoPelicula()); 
		return pelicula;
	}
	
	/**
	 * Metodo que recupera todos los registros
	 * de esta clase modelo en la base
	 * @return lista de resultados de la 
	 * clase en cuestion
	 */
	public List<Pelicula> listarPelicula() {   	
		return pl.list();
	}

	public boolean guardarPelicula(Pelicula pelicula) {
		System.out.println("crear pelicula: "+pelicula.getIdCategoria());
		return pl.insert(pelicula);
		
	}

}
