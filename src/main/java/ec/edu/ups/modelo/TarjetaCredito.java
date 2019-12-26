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
import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.CreditCardNumber;
import org.hibernate.validator.constraints.NotEmpty;

@Entity(name="tie_tarjeta_credito")
@Table(name="tie_tarjeta_credito")
public class TarjetaCredito implements Serializable{
	
	@Id
	@CreditCardNumber
	@GeneratedValue
	@Column(name="tar_numero")
	private String numeroTarjeta;
	
	@NotNull
	@Column(name="tar_cod_verificacion",length = 3)
	private String codigoValidacion;
	
	@NotNull
	@NotEmpty
	@Column(name="tar_fvencimiento")
	private Date fechaVencimiento;
	
	
	@NotNull
	@NotEmpty
	@Column(name="tar_propietario")
	private String propietario; 
	
	@ManyToOne(cascade = {CascadeType.ALL}) 
	@JoinColumn(name = "tar_usu_cedula",referencedColumnName = "usu_cedula")
	private Usuario usuario;

	/**
	 * Metodo que obtiene el objeto en cuestion de la clase
	 * @return el objeto buscado
	 */
	public String getNumeroTarjeta() {
		return numeroTarjeta;
	}

	/**
	 * Metodo que setea el valor de dicho objeto en la clase
	 * @param numeroTarjeta es el valor del atributo en cuestion
	 */
	public void setNumeroTarjeta(String numeroTarjeta) {
		this.numeroTarjeta = numeroTarjeta;
	}

	/**
	 * Metodo que obtiene el objeto en cuestion de la clase
	 * @return el objeto buscado
	 */
	public String getCodigoValidacion() {
		return codigoValidacion;
	}

	/**
	 * Metodo que setea el valor de dicho objeto en la clase
	 * @param codigoValidacion es el valor del atributo en cuestion
	 */
	public void setCodigoValidacion(String codigoValidacion) {
		this.codigoValidacion = codigoValidacion;
	}

	/**
	 * Metodo que obtiene el objeto en cuestion de la clase
	 * @return el objeto buscado
	 */
	public Date getFechaVencimiento() {
		return fechaVencimiento;
	}

	/**
	 * Metodo que setea el valor de dicho objeto en la clase
	 * @param fechaVencimiento es el valor del atributo en cuestion
	 */
	public void setFechaVencimiento(Date fechaVencimiento) {
		this.fechaVencimiento = fechaVencimiento;
	}

	/**
	 * Metodo que obtiene el objeto en cuestion de la clase
	 * @return el objeto buscado
	 */
	public String getPropietario() {
		return propietario;
	}

	/**
	 * Metodo que setea el valor de dicho objeto en la clase
	 * @param propietario es el valor del atributo en cuestion
	 */
	public void setPropietario(String propietario) {
		this.propietario = propietario;
	}

	/**
	 * Metodo que obtiene el objeto en cuestion de la clase
	 * @return el objeto buscado
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
		return "TarjetaCredito [numeroTarjeta=" + numeroTarjeta + ", codigoValidacion=" + codigoValidacion
				+ ", fechaVencimiento=" + fechaVencimiento + ", propietario=" + propietario + ", usuario=" + usuario
				+ "]";
	}

	
	 
}
