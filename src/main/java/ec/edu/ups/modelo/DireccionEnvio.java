package ec.edu.ups.modelo;

import java.io.Serializable;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity(name="tie_direccion")
@Table(name="tie_direccion")
public class DireccionEnvio implements Serializable{

	@Id
	@GeneratedValue
	@Column(name = "dir_id")
	private int idDireccion;
	
	@Column(name="dir_calle")
	private String calle;
	
	@Column(name="dir_sector")
	private String sector;
	
	@Column(name="dir_num_casa")
	private String numeroCasa;
	
	@Column(name="dir_parroquia")
	private String parroquia;
	
	@Column(name="dir_ciudad")
	private String ciudad;
	
	@Column(name="dir_provincia")
	private String provincia;
	
	@Column(name="dir_codigo_postal")
	private String zipCode;
	
	@ManyToOne(cascade = {CascadeType.ALL}) 
	@JoinColumn(name = "dir_usu_cedula",referencedColumnName = "usu_cedula")
	private Usuario usuario;

	/**
	 * Metodo que obtiene el objeto en cuestion de la clase
	 * @return el objeto buscado
	 */
	public int getIdDireccion() {
		return idDireccion;
	}

	/**
	 * Metodo que setea un valor en un atributo de la clase
	 * @param idDireccion es el valor para setear
	 * en el atributo
	 */
	public void setIdDireccion(int idDireccion) {
		this.idDireccion = idDireccion;
	}

	/**
	 * Metodo que obtiene el objeto en cuestion de la clase
	 * @return el objeto buscado
	 */
	public String getCalle() {
		return calle;
	}

	/**
	 * Metodo que setea un valor en un atributo de la clase
	 * @param calle es el valor para setear
	 * en el atributo
	 */
	public void setCalle(String calle) {
		this.calle = calle;
	}

	/**
	 * Metodo que obtiene el objeto en cuestion de la clase
	 * @return el objeto buscado
	 */
	public String getSector() {
		return sector;
	}

	/**
	 * Metodo que setea un valor en un atributo de la clase
	 * @param sector es el valor para setear
	 * en el atributo
	 */
	public void setSector(String sector) {
		this.sector = sector;
	}

	/**
	 * Metodo que obtiene el objeto en cuestion de la clase
	 * @return el objeto buscado
	 */
	public String getNumeroCasa() {
		return numeroCasa;
	}

	/**
	 * Metodo que setea un valor en un atributo de la clase
	 * @param numeroCasa es el valor para setear
	 * en el atributo
	 */
	public void setNumeroCasa(String numeroCasa) {
		this.numeroCasa = numeroCasa;
	}

	/**
	 * Metodo que obtiene el objeto en cuestion de la clase
	 * @return el objeto buscado
	 */
	public String getParroquia() {
		return parroquia;
	}

	/**
	 * Metodo que setea un valor en un atributo de la clase
	 * @param parroquia es el valor para setear
	 * en el atributo
	 */
	public void setParroquia(String parroquia) {
		this.parroquia = parroquia;
	}

	/**
	 * Metodo que obtiene el objeto en cuestion de la clase
	 * @return el objeto buscado
	 */
	public String getCiudad() {
		return ciudad;
	}

	/**
	 * Metodo que setea un valor en un atributo de la clase
	 * @param ciudad es el valor para setear
	 * en el atributo
	 */
	public void setCiudad(String ciudad) {
		this.ciudad = ciudad;
	}
	/**
	 * Metodo que obtiene el objeto en cuestion de la clase
	 * @return el objeto buscado
	 */

	public String getProvincia() {
		return provincia;
	}

	/**
	 * Metodo que setea un valor en un atributo de la clase
	 * @param provincia es el valor para setear
	 * en el atributo
	 */
	public void setProvincia(String provincia) {
		this.provincia = provincia;
	}

	/**
	 * Metodo que obtiene el objeto en cuestion de la clase
	 * @return el objeto buscado
	 */
	public String getZipCode() {
		return zipCode;
	}

	/**
	 * Metodo que setea un valor en un atributo de la clase
	 * @param zipCode es el valor para setear
	 * en el atributo
	 */
	public void setZipCode(String zipCode) {
		this.zipCode = zipCode;
	}

	/**
	 * Metodo que obtiene el objeto en cuestion de la clase
	 * @return el objeto buscado
	 */
	public Usuario getUsuario() {
		return usuario;
	}
/**
 * Metodo que setea un valor en un atributo de la clase
 * @param usuario es el valor para setear
 * en el atributo
 */
	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

	@Override
	public String toString() {
		return "DireccionEnvio [idDireccion=" + idDireccion + ", calle=" + calle + ", sector=" + sector
				+ ", numeroCasa=" + numeroCasa + ", parroquia=" + parroquia + ", ciudad=" + ciudad + ", provincia="
				+ provincia + ", zipCode=" + zipCode + ", usuario=" + usuario + "]";
	}
	
	
	
}
