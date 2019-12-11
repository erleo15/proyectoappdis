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
	
	public void delete(Categoria categoria) {
		em.remove(categoria);
	}
	
	public void update(int idViejo,Categoria categoria) {
	
		em.remove(em.find(Categoria.class, idViejo));
		em.persist(categoria);
		
	}
	
	public  Categoria find(int id) {
		em.find(Categoria.class, id);
		return null;
	}
	
	public List<Categoria> list(){   
		
		Query query = em.createQuery("SELECT c from tie_categoria c", Categoria.class);
		return query.getResultList();
	}

}
