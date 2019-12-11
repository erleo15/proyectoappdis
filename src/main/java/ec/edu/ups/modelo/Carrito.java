package ec.edu.ups.modelo;

import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType; 

@Entity
@Table(name="tie_carrito")
public class Carrito {

	@Id
	@Column(name="cdet_numero")
	private int numFDetalle;
	
	@Column(name="cdet_cantidad")
	private int cantidad;
	
	@Column(name="cdet_total")
	private int totalCarrito;
	
	@Temporal(TemporalType.DATE)
	@Column(name="cdet_fecha")
	private Date fecha;
	
	
	@ManyToOne(cascade = {CascadeType.ALL}) 
	@JoinColumn(name = "cdet_pel_id",referencedColumnName = "pel_id")
	private Pelicula pelicula;
 
 
	
	@ManyToOne(cascade = {CascadeType.ALL}) 
	@JoinColumn(name = "cdet_usu_cedula",referencedColumnName = "usu_cedula")
	private Usuario usuario;



	public int getNumFDetalle() {
		return numFDetalle;
	}



	public void setNumFDetalle(int numFDetalle) {
		this.numFDetalle = numFDetalle;
	}



	public int getCantidad() {
		return cantidad;
	}



	public void setCantidad(int cantidad) {
		this.cantidad = cantidad;
	}



	public int getTotalCarrito() {
		return totalCarrito;
	}



	public void setTotalCarrito(int totalCarrito) {
		this.totalCarrito = totalCarrito;
	}



	public Date getFecha() {
		return fecha;
	}



	public void setFecha(Date fecha) {
		this.fecha = fecha;
	}



	public Pelicula getPelicula() {
		return pelicula;
	}



	public void setPelicula(Pelicula pelicula) {
		this.pelicula = pelicula;
	}



	public Usuario getUsuario() {
		return usuario;
	}



	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}



	@Override
	public String toString() {
		return "Carrito [numFDetalle=" + numFDetalle + ", cantidad=" + cantidad + ", totalCarrito=" + totalCarrito
				+ ", fecha=" + fecha + ", pelicula=" + pelicula + ", usuario=" + usuario + "]";
	}
	
	

}
