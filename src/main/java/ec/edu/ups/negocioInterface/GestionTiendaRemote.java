package ec.edu.ups.negocioInterface;

import java.util.List;

import javax.ejb.Remote;

import ec.edu.ups.modelo.Pelicula;

@Remote
public interface GestionTiendaRemote {

		//crudproductos
		//crudusuarios
		//
		public List<Pelicula> peliculasMasVendidas();
		public String realizarCompra();
}
