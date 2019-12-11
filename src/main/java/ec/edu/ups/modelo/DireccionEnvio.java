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

	public int getIdDireccion() {
		return idDireccion;
	}

	public void setIdDireccion(int idDireccion) {
		this.idDireccion = idDireccion;
	}

	public String getCalle() {
		return calle;
	}

	public void setCalle(String calle) {
		this.calle = calle;
	}

	public String getSector() {
		return sector;
	}

	public void setSector(String sector) {
		this.sector = sector;
	}

	public String getNumeroCasa() {
		return numeroCasa;
	}

	public void setNumeroCasa(String numeroCasa) {
		this.numeroCasa = numeroCasa;
	}

	public String getParroquia() {
		return parroquia;
	}

	public void setParroquia(String parroquia) {
		this.parroquia = parroquia;
	}

	public String getCiudad() {
		return ciudad;
	}

	public void setCiudad(String ciudad) {
		this.ciudad = ciudad;
	}

	public String getProvincia() {
		return provincia;
	}

	public void setProvincia(String provincia) {
		this.provincia = provincia;
	}

	public String getZipCode() {
		return zipCode;
	}

	public void setZipCode(String zipCode) {
		this.zipCode = zipCode;
	}

	public Usuario getUsuario() {
		return usuario;
	}

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
