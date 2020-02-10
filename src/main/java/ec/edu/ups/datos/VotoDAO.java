package ec.edu.ups.datos;

import java.util.List;

import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.persistence.EntityManager;

import ec.edu.ups.modelo.Pelicula;
import ec.edu.ups.modelo.Voto;
 

@Stateless
public class VotoDAO {

	@Inject
	private EntityManager em;
	/**
	 * metodo que inserta el objeto de esta clase en la base
	 * 
	 * @param objeto es la instancia de la clase en cuestiopn a administrar
	 */
	public boolean insert(Voto voto) {
		try {
			em.persist(voto);
			return true;
		}catch(Exception e){
			e.printStackTrace();
		}
		return false;
	}
	
	/**
	 * metodo que actualiza el objeto de esta clase en la BD
	 * 
	 * @param id es la instancia de la clase en cuestiopn a administrar
	 */
	public boolean actualizar(Voto voto) {
		try{
			em.merge(voto);
			return true;
		}catch(Exception e) {
			e.printStackTrace();
			return false;
		}
	}
	
	/**
	 * Metodo que busca un
	 * @param id es la instancia de la clase en cuestiopn a administrar
	 * @return retorna un objeto a la clase
	 */
	public Voto find(int id ) { 
		return em.find(Voto.class, id);
	}
	
	/**
	 * Metodo que lista los objetos de esta clase guardados en
	 * la base de datos
	 * @return una lista con todos los resultados
	 */
	public List<Voto> getVotos(){
		return em.createQuery("SELECT c from Voto c", Voto.class).getResultList();
	}
	
	
	/**
	 * Metodo que elimina el objeto de una clase mediante
	 * la instancia id de la misma
	 * @param idVoto instancia de la clase en cuestion a administrar
	 * @return
	 */
	public boolean remove(int idVoto ) { 
		try {
			//Voto voto = find(idVoto);
			//System.out.println("voto encontrado"+voto);
		return em.createNativeQuery("DELETE FROM tie_voto where car_numero = "+idVoto).executeUpdate() != 0;
			 
		 
		}catch(Exception e) {
			e.printStackTrace();
			return false;
		}
	}
	
	/**
	 * Metodo que elimina el objeto de una clase mediante
	 * dos instancias de la misma
	 * @param idPelicula instancia de la clase en cuestion a administrar
	 * @param cedula instancia de la clase en cuestion a administrar
	 * @return
	 */
	public boolean removeVotoXidAndCedula(int idPelicula, String cedula ) { 
		try {
			//Voto voto = find(idVoto);
			String sql = "DELETE FROM tie_voto where vot_pel_id = "+idPelicula + " and vot_usu_cedula = '"+cedula+"';";
			//System.out.println("voto encontrado"+voto);
			
			return em.createNativeQuery(sql).executeUpdate() != 0;
			 
		 
		}catch(Exception e) {
			e.printStackTrace();
			return false;
		}
	}
	
	
	
	 
}
