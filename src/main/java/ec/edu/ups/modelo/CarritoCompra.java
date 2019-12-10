package ec.edu.ups.modelo;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="tie_carrito")
public class CarritoCompra {
	
	@Id
	@Column(name = "car_id")
	private int idcarrito;
	
	@Column(name="car_cantidad")
	private int cantidad;
	
	@ManyToOne(cascade = {CascadeType.ALL}) 
	@JoinColumn(name = "car_usu_id",referencedColumnName = "usu_id")
	private Usuario usuario;
	
	@ManyToOne(cascade = {CascadeType.ALL}) 
	@JoinColumn(name = "car_pel_id",referencedColumnName = "pel_id")
	private Pelicula pelicula;

	public int getIdcarrito() {
		return idcarrito;
	}

	public void setIdcarrito(int idcarrito) {
		this.idcarrito = idcarrito;
	}

	public int getCantidad() {
		return cantidad;
	}

	public void setCantidad(int cantidad) {
		this.cantidad = cantidad;
	}

	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

	public Pelicula getPelicula() {
		return pelicula;
	}

	public void setPelicula(Pelicula pelicula) {
		this.pelicula = pelicula;
	}
	
	
	 
}
