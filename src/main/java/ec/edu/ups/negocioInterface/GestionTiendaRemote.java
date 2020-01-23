package ec.edu.ups.negocioInterface;

import java.util.List;

import javax.ejb.Remote;

import ec.edu.ups.modelo.Pelicula;
import ec.edu.ups.modelo.Usuario;

@Remote
public interface GestionTiendaRemote {

		
	/*
	 * Parte Para Crud Usuario
	 */
	public boolean crearUsuario(Usuario usuario);
	
	
	
	/*
	 * Parte Para Crud Peliculas
	 */
	
	/*
	 * Parte para crud Categoria
	 */
	
	//crudproductos
		//crudusuarios
		//
		public List<Pelicula> peliculasMasVendidas();
		public String realizarCompra();
}
