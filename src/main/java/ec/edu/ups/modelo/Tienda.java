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

@Entity(name="tie_tienda")
@Table(name="tie_tienda")
public class Tienda implements Serializable{

	@Id
	@GeneratedValue
	@Column(name="tie_id")
	private int idTienda;
	
	@Column(name="tie_nombre")
	private String nombre;
	
	@Column(name="tie_direccion")
	private String direccion;
	
	@Column(name="tie_propietario")
	private String propietario;
	
	@Temporal(TemporalType.DATE)
	@Column(name = "tie_fcreacion")
	private Date fechaCreacion;

	
	/**
	 * Metodo que obtiene el objeto en cuestion de la clase
	 * @return el objeto buscado
	 */
	public int getIdTienda() {
		return idTienda;
	}

	public void setIdTienda(int idTienda) {
		this.idTienda = idTienda;
	}

	/**
	 * Metodo que obtiene el objeto en cuestion de la clase
	 * @return el objeto buscado
	 */
	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	/**
	 * Metodo que obtiene el objeto en cuestion de la clase
	 * @return el objeto buscado
	 */
	public String getDireccion() {
		return direccion;
	}

	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}

	/**
	 * Metodo que obtiene el objeto en cuestion de la clase
	 * @return el objeto buscado
	 */
	public String getPropietario() {
		return propietario;
	}

	public void setPropietario(String propietario) {
		this.propietario = propietario;
	}

	/**
	 * Metodo que obtiene el objeto en cuestion de la clase
	 * @return el objeto buscado
	 */
	public Date getFechaCreacion() {
		return fechaCreacion;
	}
/**
 * Metodo que setea un valor en un atributo
 * @param fechaCreacion el valor del atributo en cuestion
 */
	public void setFechaCreacion(Date fechaCreacion) {
		this.fechaCreacion = fechaCreacion;
	}

	@Override
	public String toString() {
		return "Tienda [idTienda=" + idTienda + ", nombre=" + nombre + ", direccion=" + direccion + ", propietario="
				+ propietario + ", fechaCreacion=" + fechaCreacion + "]";
	}
	
	
	
	
}
