package ec.edu.ups.datos;

import java.util.List;

import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.persistence.EntityManager;

import ec.edu.ups.modelo.Pelicula;
import ec.edu.ups.modelo.Usuario;

@Stateless
public class PeliculaDAO {

	@Inject
	EntityManager em;
	
	public void insert(Pelicula pelicula) {
		em.persist(pelicula);
	}
	
	public void delete(int id) {
		em.remove(find(id));
	}
	
	public void update(Pelicula pelicula) {
	
		em.remove(em.find(Pelicula.class, pelicula.getCodigoPelicula()));
		em.persist(pelicula);
		
	}
	
	public  Pelicula find(int id) {
		return em.find(Pelicula.class, id); 
	}
	
	public List<Pelicula> list(){    
		return  em.createQuery("SELECT c from tie_pelicula c", Pelicula.class).getResultList(); 
	}
	
}
