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
	private List<Categoria> listaCategoria;
	
	@Inject
	private CategoriaDAO categoriaDAO;
	
	@PostConstruct
	public void init() {
		categoria = new Categoria();
		listaCategoria = new ArrayList<Categoria>();
	}
	
	public Categoria getCategoria() {
		return categoria;
	}

	public void setCategoria(Categoria categoria) {
		this.categoria = categoria;
	}

	public List<Categoria> getListaCategoria() {
		return listaCategoria;
	}

	public void setListaCategoria(List<Categoria> listaCategoria) {
		this.listaCategoria = listaCategoria;}
	
	public String guardarCategoria() {
		categoriaDAO.insert(categoria);
		return null;
	}
	
	public String eliminarCategoria() {
		categoriaDAO.delete(categoria);
		return null;
	}
	
	public String actualizarCategoria() {
		categoriaDAO.update(categoria.getIdCategoria(),categoria);
		return null;
	}
	
	public String buscarCategoria() {
		categoria = categoriaDAO.find(categoria.getIdCategoria());
		return null;
	}
	
	public List<Categoria> listarCategoria() {
		return categoriaDAO.list(); 
	}
 


	@Override
	public String toString() {
		return "CategoriaBean [categoria=" + categoria + ", listaCategoria=" + listaCategoria + ", categoriaDAO="
				+ categoriaDAO + "]";
	}
	
}
