package ec.edu.ups.negocioBean;

import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.inject.Inject;

import ec.edu.ups.datos.CategoriaDAO;
import ec.edu.ups.modelo.Categoria;

@ManagedBean
public class CategoriaBean {

	private Categoria categoria;
	private List<Categoria> listaCategoria;
	
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
		return null;
	}
	
	public List<Categoria> getListaCategoria() {
		return listaCategoria;
	}
	
	public void setCategoriaDAO(CategoriaDAO categoriaDAO) {
		this.categoriaDAO = categoriaDAO;
	}
	
	public  List<Categoria> listarCategorias() {
		listaCategoria=categoriaDAO.getCategorias();
		return listaCategoria;
	}
	
}
