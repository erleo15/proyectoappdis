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

/**
 * Clase para guardar los datos del carrito
 * por cada uno de los clientes
 * @author erleo15
 *
 */
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



	/**
	 * Metodo que obtiene el objeto en cuestion de la clase
	 * @return el objeto buscado
	 */
	public int getIdCarrito() {
		return idCarrito;
	}


	/**
	 * Metodo que setea el valor de dicho objeto en la clase
	 * @param el valor del atributo a poner
	 */
	public void setIdCarrito(int idCarrito) {
		this.idCarrito = idCarrito;
	}


	/**
	 * Metodo que obtiene el objeto en cuestion de la clase
	 * @return el objeto buscado
	 */
	public int getCantidad() {
		return cantidad;
	}


	/**
	 * Metodo que setea el valor de dicho objeto en la clase
	 * @param cantidad el valor del atributo a poner
	 */
	public void setCantidad(int cantidad) {
		this.cantidad = cantidad;
	}


	/**
	 * Metodo que obtiene el objeto en cuestion de la clase
	 * @return el atributo en cuestion
	 */
	public int getTotalCarrito() {
		return totalCarrito;
	}


	/**
	 * Metodo que setea el valor de dicho objeto en la clase
	 * @param totalCarrito es el valor del atributo en cuestion
	 */
	public void setTotalCarrito(int totalCarrito) {
		this.totalCarrito = totalCarrito;
	}


	/**
	 * Metodo que obtiene el objeto en cuestion de la clase
	 * @return el objeto en cuestion
	 */
	public Date getFecha() {
		return fecha;
	}


	/**
	 * Metodo que setea el valor de dicho objeto en la clase
	 * @param fecha es el valor del atributo en cuestion
	 */
	public void setFecha(Date fecha) {
		this.fecha = fecha;
	}


	/**
	 * Metodo que obtiene el objeto en cuestion de la clase
	 * @return el objeto en cuestion
	 */
	public Pelicula getPelicula() {
		return pelicula;
	}


	/**
	 * Metodo que setea el valor de dicho objeto en la clase
	 * @param pelicula es el valor del atributo en cuestion
	 */
	public void setPelicula(Pelicula pelicula) {
		this.pelicula = pelicula;
	}


	/**
	 * Metodo que obtiene el objeto en cuestion de la clase
	 * @return el objeto en cuestion
	 */
	public Usuario getUsuario() {
		return usuario;
	}



	/**
	 * Metodo que setea el valor de dicho objeto en la clase
	 * @param usuario es el valor del atributo en cuestion
	 */
	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}



	@Override
	public String toString() {
		return "Carrito [idCarrito=" + idCarrito + ", cantidad=" + cantidad + ", totalCarrito=" + totalCarrito
				+ ", fecha=" + fecha + ", pelicula=" + pelicula + ", usuario=" + usuario + "]";
	}
	
	

}
