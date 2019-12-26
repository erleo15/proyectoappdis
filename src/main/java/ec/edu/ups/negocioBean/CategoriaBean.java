package ec.edu.ups.negocioBean;


import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.inject.Inject;

import ec.edu.ups.datos.CategoriaDAO;
import ec.edu.ups.modelo.Categoria;

/**
 * Clase que administra desde la vista 
 * la clase modeloen cuestion
 * @author erleo15
 *
 */
@ManagedBean
@ViewScoped
public class CategoriaBean {

	private Categoria categoria;  
	
	@Inject
	private CategoriaDAO categoriaDAO;
	
	/**
	 * Metodo que inicializalos los objetos modelos
	 */
	@PostConstruct
	public void init() {
		categoria = new Categoria();
	}
	
	/**
	 * Metodo que obtiene obtiene el valor del objeto
	 * @return retorna un objeto
	 */
	public Categoria getCategoria() {
		return categoria;
	}

	/**
	 * Metodo que setea el atributo
	 * @param categoria valor a setear
	 */
	public void setCategoria(Categoria categoria) {
		this.categoria = categoria;
	}

	 /**
	  * Metodo que guarda desde la vista 
	  * @return una cadena que redirecciona
	  */
	public String guardarCategoria() {
		categoriaDAO.insert(categoria);
		
		return "peliculas.xhtml";
	}
	
	/**
	 * Metodo que elimina un registro de esta clase
	 * modelo en la base de datos
	 * @param id el primary key de la tabla
	 * @return una cadena que redirecciona
	 */
	public String eliminarCategoria(int id) {
		categoriaDAO.delete(id);
		return null;
	}
	
	/**
	 * Metodo que actualiza un registro de esta clase modelo 
	 * en la base de datos
	 * @return una cadena que redirecciona
	 */
	public String actualizarCategoria() {
		categoriaDAO.update(categoria);
		return null;
	}
	
	/**
	 * Metodo para buscar un objeto de esta
	 * clase en la base
	 * @return el objeto encontrado
	 */
	public Categoria buscarCategoria() {
		return  categoriaDAO.find(categoria.getIdCategoria());
		
	}
	
	/**
	 * Metodo que recupera todos los registros
	 * de esta clase modelo en la base
	 * @return lista de resultados de la 
	 * clase en cuestion
	 */
	public List<Categoria> listarCategoria() {
		return categoriaDAO.list(); 
	}

	public boolean guardarCategoria(Categoria categoria) { 
		return categoriaDAO.insert(categoria); 
	}
 

	
}
