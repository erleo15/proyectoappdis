package ec.edu.ups.datos;

import java.util.List;

import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.Query;

import ec.edu.ups.modelo.Categoria;
import ec.edu.ups.modelo.Usuario;


@Stateless
public class UsuarioDAO {

	@Inject
	EntityManager em;
	
	public void insert(Usuario usuario) {
		em.persist(usuario);
	}
	
	public void delete(String cedula) {
		em.remove(find(cedula));
	}
	
	public void update(Usuario usuario) {
	
		em.remove(em.find(Usuario.class, usuario.getCedula()));
		em.persist(usuario);
		
	}
	
	public  Usuario find(String cedula) { 
		return em.find(Usuario.class, cedula); 
	}
	
	public List<Usuario> list(){    
		return  em.createQuery("SELECT c from tie_usuario c", Usuario.class).getResultList(); 
	}

}
