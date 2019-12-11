package ec.edu.ups.negocioBean;


import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.inject.Inject;

import ec.edu.ups.datos.CategoriaDAO;
import ec.edu.ups.modelo.Categoria;

@ManagedBean
@ViewScoped
public class CategoriaBean {

	private Categoria categoria; 
	//private List<Categoria> listaCategoria;
	
	@Inject
	private CategoriaDAO categoriaDAO;
	
	@PostConstruct
	public void init() {
		categoria = new Categoria();
	}
	
	public Categoria getCategoria() {
		return categoria;
	}

	public void setCategoria(Categoria categoria) {
		this.categoria = categoria;
	}

	 
	public String guardarCategoria() {
		categoriaDAO.insert(categoria);
		
		return "peliculas.xhtml";
	}
	
	public String eliminarCategoria(int id) {
		categoriaDAO.delete(id);
		return null;
	}
	
	public String actualizarCategoria() {
		categoriaDAO.update(categoria);
		return null;
	}
	
	public Categoria buscarCategoria() {
		return  categoriaDAO.find(categoria.getIdCategoria());
		
	}
	
	public List<Categoria> listarCategoria() {
		return categoriaDAO.list(); 
	}
 

	
}
