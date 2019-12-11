package ec.edu.ups.datos;

import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.persistence.EntityManager;

import ec.edu.ups.modelo.Usuario;


@Stateless
public class UsuarioDAO {

	@Inject
	EntityManager em;
	
	public void insert(Usuario usuario) {
		em.persist(usuario);
	}
	
	public void delete(Usuario usuario) {
		em.remove(usuario);
	}
	
	public void update(String cedulaAnterior,Usuario usuario) {
	
		em.remove(em.find(Usuario.class, cedulaAnterior));
		em.persist(usuario);
		
	}
	
	public  Usuario find(String cedula) {
		return em.find(Usuario.class, cedula);
		
	}

}
