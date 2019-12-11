package ec.edu.ups.modelo;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType; 

@Entity(name="tie_carrito")
@Table(name="tie_carrito")
public class Carrito implements Serializable{

	@Id
	@GeneratedValue
	@Column(name="car_numero")
	private int idCarrito;
	
	@Column(name="car_cantidad")
	private int cantidad;
	
	@Column(name="car_total")
	private int totalCarrito;
	
	@Temporal(TemporalType.DATE)
	@Column(name="car_fecha")
	private Date fecha;
	
	
	@ManyToOne(cascade = {CascadeType.ALL}) 
	@JoinColumn(name = "car_pel_id",referencedColumnName = "pel_id")
	private Pelicula pelicula;
 
 
	
	@ManyToOne(cascade = {CascadeType.ALL}) 
	@JoinColumn(name = "car_usu_cedula",referencedColumnName = "usu_cedula")
	private Usuario usuario;



	public int getIdCarrito() {
		return idCarrito;
	}



	public void setIdCarrito(int idCarrito) {
		this.idCarrito = idCarrito;
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
		return "Carrito [idCarrito=" + idCarrito + ", cantidad=" + cantidad + ", totalCarrito=" + totalCarrito
				+ ", fecha=" + fecha + ", pelicula=" + pelicula + ", usuario=" + usuario + "]";
	}
	
	

}
