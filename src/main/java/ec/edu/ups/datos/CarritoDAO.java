package ec.edu.ups.datos;

import java.util.List;

import javax.ejb.Stateless;

import ec.edu.ups.modelo.Carrito;

/**
 * Clase para administrar el carrito en la base de datos
 * @author erleo15
 *
 */
@Stateless
public class CarritoDAO {

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
	public Carrito find(int id ) {
		return null;
	}
	
	/**
	 * Metodo que lista los objetos de esta clase guardados en
	 * la base de datos
	 * @return una lista con todos los resultados
	 */
	public List<Carrito> list(){
		return null;
	}
	
}
