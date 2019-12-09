package ec.edu.ups.datos;

import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.persistence.EntityManager;

import ec.edu.ups.modelo.Pelicula;

@Stateless
public class PeliculaDAO {

	@Inject
	EntityManager em;
	
	public void insert(Pelicula pelicula) {
		em.persist(pelicula);
	}
	
	public void delete(Pelicula pelicula) {
		em.remove(pelicula);
	}
	
	public void update(String idViejo,Pelicula pelicula) {
	
		em.remove(em.find(Pelicula.class, idViejo));
		em.persist(pelicula);
		
	}
	
	public  Pelicula find(int id) {
		em.find(Pelicula.class, id);
		return null;
	}
}
