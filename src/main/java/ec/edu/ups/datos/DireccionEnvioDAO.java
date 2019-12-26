package ec.edu.ups.datos;

import java.util.List;

import javax.ejb.Stateless;

import ec.edu.ups.modelo.Carrito;
import ec.edu.ups.modelo.DireccionEnvio;

@Stateless
public class DireccionEnvioDAO {

	/**
	 * metodo que inserta el objeto de esta clase en la base
	 * 
	 * @param objeto es la instancia de la clase en cuestiopn a administrar
	 */
	public void insert(Carrito objeto) {
		
	}
	
	/**
	 * metodo que actualiza el objeto de esta clase en la BD
	 * 
	 * @param id es la instancia de la clase en cuestiopn a administrar
	 */
	public void actualizar(int id) {
		
	}
	
	/**
	 * Metodo que busca un
	 * @param id es la instancia de la clase en cuestiopn a administrar
	 * @return retorna un objeto a la clase
	 */
	public DireccionEnvio find(int id ) {
		return null;
	}
	
	/**
	 * Metodo que lista los objetos de esta clase guardados en
	 * la base de datos
	 * @return una lista con todos los resultados
	 */
	public List<DireccionEnvio> list(){
		return null;
	}
}
