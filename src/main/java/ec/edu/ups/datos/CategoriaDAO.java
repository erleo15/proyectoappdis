package ec.edu.ups.datos;

import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.persistence.EntityManager;

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

}
