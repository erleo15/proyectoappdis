package ec.edu.ups.modelo;

import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.CreditCardNumber;
import org.hibernate.validator.constraints.NotEmpty;

@Entity
@Table(name="tie_tarjeta_credito")
public class TarjetaCredito {
	
	@Id
	@CreditCardNumber
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

	public String getNumeroTarjeta() {
		return numeroTarjeta;
	}

	public void setNumeroTarjeta(String numeroTarjeta) {
		this.numeroTarjeta = numeroTarjeta;
	}

	public String getCodigoValidacion() {
		return codigoValidacion;
	}

	public void setCodigoValidacion(String codigoValidacion) {
		this.codigoValidacion = codigoValidacion;
	}

	public Date getFechaVencimiento() {
		return fechaVencimiento;
	}

	public void setFechaVencimiento(Date fechaVencimiento) {
		this.fechaVencimiento = fechaVencimiento;
	}

	public String getPropietario() {
		return propietario;
	}

	public void setPropietario(String propietario) {
		this.propietario = propietario;
	}

	public Usuario getUsuario() {
		return usuario;
	}

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
