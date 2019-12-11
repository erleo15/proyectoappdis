package ec.edu.ups.datos;

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
	
	public void delete(int idCategoria) {
		em.remove(find(idCategoria));
	}
	
	public void update(Categoria categoria) {
	
		em.remove(em.find(Categoria.class, categoria.getIdCategoria()));
		em.persist(categoria);
		
	}
	
	public  Categoria find(int id) {
		return em.find(Categoria.class, id);
		
	}
	
	public List<Categoria> list(){  
		return em.createQuery("SELECT c from tie_categoria c", Categoria.class).getResultList();
	}

}
