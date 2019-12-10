package ec.edu.ups.datos;

import java.util.ArrayList;
import java.util.List;

import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.Query;

import ec.edu.ups.modelo.Categoria;

@Stateless
public class CategoriaDAO {
	
	@Inject
	EntityManager em;
	
	public void insert(Categoria categoria) {
		em.persist(categoria);
	}
	
	public void delete(Categoria categoria) {
		em.remove(categoria);
	}
	
	public void update(String idViejo,Categoria categoria) {
	
		em.remove(em.find(Categoria.class, idViejo));
		em.persist(categoria);
		
	}
	
	public  Categoria find(int id) {
		em.find(Categoria.class, id);
		return null;
	}
	
	public List<Categoria> getCategorias(){
		List<Categoria> lista= new ArrayList<Categoria>();  
		Query query = em.createQuery("Select c.cat_id,c.cat_nombre,c.cat_descripcion from tie_categoria c");
		lista = query.getResultList();
		return lista; 
	}

}
