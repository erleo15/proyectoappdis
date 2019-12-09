package ec.edu.ups.negocioBean;

import javax.annotation.PostConstruct;
import javax.ejb.Stateless;
import javax.inject.Inject;

import ec.edu.ups.datos.CategoriaDAO;
import ec.edu.ups.modelo.Categoria;

@Stateless
public class CategoriaBean {

	private Categoria categoria;
	
	@Inject
	private CategoriaDAO categoriaDAO;
	
	@PostConstruct
	public void init() {
		categoria = new Categoria();
	}
	
	public String guardarCategoria() {
		categoriaDAO.insert(categoria);
		return null;
	}
	
}
