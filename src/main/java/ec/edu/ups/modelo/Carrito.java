package ec.edu.ups.modelo;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType; 

/**
 * Clase para guardar los datos del carrito
 * por cada uno de los clientes
 * @author erleo15
 *
 */
@Entity
@Table(name="tie_carrito")
public class Carrito implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 9206737450519557902L;

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
	
	
	@Column(name = "car_pel_id")
	private int idPelicula;
  
	
	@Column(name = "car_usu_cedula")
	private String cedulaUsuario;


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


	public int getIdPelicula() {
		return idPelicula;
	}


	public void setIdPelicula(int idPelicula) {
		this.idPelicula = idPelicula;
	}


	public String getCedulaUsuario() {
		return cedulaUsuario;
	}


	public void setCedulaUsuario(String cedulaUsuario) {
		this.cedulaUsuario = cedulaUsuario;
	}


	@Override
	public String toString() {
		return "Carrito [idCarrito=" + idCarrito + ", cantidad=" + cantidad + ", totalCarrito=" + totalCarrito
				+ ", fecha=" + fecha + ", idPelicula=" + idPelicula + ", cedulaUsuario=" + cedulaUsuario + "]";
	}
	
	

}
