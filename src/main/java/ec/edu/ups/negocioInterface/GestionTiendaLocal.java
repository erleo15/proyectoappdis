package ec.edu.ups.negocioInterface;

import java.util.List;

import javax.ejb.Local;

import ec.edu.ups.modelo.Pelicula;

@Local
public interface GestionTiendaLocal {

	//registratproductos
	//registrarusuarios
	//
	public List<Pelicula> peliculasMasVendidas();
	public String realizarCompra();
	
}
