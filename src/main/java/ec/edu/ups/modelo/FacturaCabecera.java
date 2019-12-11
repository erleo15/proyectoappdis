package ec.edu.ups.modelo;

import java.io.Serializable;
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
import javax.validation.constraints.NotNull;

@Entity(name="tie_fcabecera")
@Table(name="tie_fcabecera")
public class FacturaCabecera implements Serializable{

	@Id
	@Column(name="fcab_num_factura")
	private String numeroFactura;
	
	@NotNull
	@Column(name="fcab_fecha")
	@Temporal(TemporalType.TIMESTAMP)
	private Date fecha;
	
	
	@Column(name="fcab_subtotal",precision = 2)
	private double subtotal;
	
	@Column(name="fcab_descuento",precision = 2)
	private double descuento;
	
	@Column(name="fcab_iva",precision = 2)
	private double iva;
	
	@Column(name="fcab_total",precision = 2)
	private double total;
	
	@Column(name="fcab_estado")
	private String estado;
	
	@ManyToOne(cascade = {CascadeType.ALL}) 
	@JoinColumn(name = "fcab_usu_id",referencedColumnName = "usu_cedula")
	private Usuario usuario;
	
	@ManyToOne(cascade = {CascadeType.ALL}) 
	@JoinColumn(name = "fcab_tar_numero",referencedColumnName = "tar_numero")
	private TarjetaCredito tarjetaCredito;
	
	@ManyToOne(cascade = {CascadeType.ALL}) 
	@JoinColumn(name = "fcab_dir_id",referencedColumnName = "dir_id")
	private DireccionEnvio direccionEnvio;

	public String getNumeroFactura() {
		return numeroFactura;
	}

	public void setNumeroFactura(String numeroFactura) {
		this.numeroFactura = numeroFactura;
	}

	public Date getFecha() {
		return fecha;
	}

	public void setFecha(Date fecha) {
		this.fecha = fecha;
	}

	public double getSubtotal() {
		return subtotal;
	}

	public void setSubtotal(double subtotal) {
		this.subtotal = subtotal;
	}

	public double getDescuento() {
		return descuento;
	}

	public void setDescuento(double descuento) {
		this.descuento = descuento;
	}

	public double getIva() {
		return iva;
	}

	public void setIva(double iva) {
		this.iva = iva;
	}

	public double getTotal() {
		return total;
	}

	public void setTotal(double total) {
		this.total = total;
	}

	public String getEstado() {
		return estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}

	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

	public TarjetaCredito getTarjetaCredito() {
		return tarjetaCredito;
	}

	public void setTarjetaCredito(TarjetaCredito tarjetaCredito) {
		this.tarjetaCredito = tarjetaCredito;
	}

	public DireccionEnvio getDireccionEnvio() {
		return direccionEnvio;
	}

	public void setDireccionEnvio(DireccionEnvio direccionEnvio) {
		this.direccionEnvio = direccionEnvio;
	}

	@Override
	public String toString() {
		return "FacturaCabecera [numeroFactura=" + numeroFactura + ", fecha=" + fecha + ", subtotal=" + subtotal
				+ ", descuento=" + descuento + ", iva=" + iva + ", total=" + total + ", estado=" + estado + ", usuario="
				+ usuario + ", tarjetaCredito=" + tarjetaCredito + ", direccionEnvio=" + direccionEnvio + "]";
	}
	
	
 

	 
}
