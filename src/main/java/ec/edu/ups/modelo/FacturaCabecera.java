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

	/**
	 * Metodo que obtiene el objeto en cuestion de la clase
	 * @return el objeto buscado
	 */
	public String getNumeroFactura() {
		return numeroFactura;
	}

	/**
	 * Metodo que setea un valor en un atributo
	 * @param numeroFactura el valor del atributo en cuestion
	 */
	public void setNumeroFactura(String numeroFactura) {
		this.numeroFactura = numeroFactura;
	}

	/**
	 * Metodo que obtiene el objeto en cuestion de la clase
	 * @return el objeto buscado
	 */
	public Date getFecha() {
		return fecha;
	}

	/**
	 * Metodo que setea un valor en un atributo
	 * @param fecha el valor del atributo en cuestion
	 */
	public void setFecha(Date fecha) {
		this.fecha = fecha;
	}

	/**
	 * Metodo que obtiene el objeto en cuestion de la clase
	 * @return el objeto buscado
	 */
	public double getSubtotal() {
		return subtotal;
	}

	/**
	 * Metodo que setea un valor en un atributo
	 * @param subtotal el valor del atributo en cuestion
	 */
	public void setSubtotal(double subtotal) {
		this.subtotal = subtotal;
	}

	/**
	 * Metodo que obtiene el objeto en cuestion de la clase
	 * @return el objeto buscado
	 */
	public double getDescuento() {
		return descuento;
	}

	/**
	 * Metodo que setea un valor en un atributo
	 * @param descuento el valor del atributo en cuestion
	 */
	public void setDescuento(double descuento) {
		this.descuento = descuento;
	}

	/**
	 * Metodo que obtiene el objeto en cuestion de la clase
	 * @return el objeto buscado
	 */
	public double getIva() {
		return iva;
	}

	/**
	 * Metodo que setea un valor en un atributo
	 * @param iva el valor del atributo en cuestion
	 */
	public void setIva(double iva) {
		this.iva = iva;
	}

	/**
	 * Metodo que obtiene el objeto en cuestion de la clase
	 * @return el objeto buscado
	 */
	public double getTotal() {
		return total;
	}

	/**
	 * Metodo que setea un valor en un atributo
	 * @param total el valor del atributo en cuestion
	 */
	public void setTotal(double total) {
		this.total = total;
	}

	/**
	 * Metodo que obtiene el objeto en cuestion de la clase
	 * @return el objeto buscado
	 */
	public String getEstado() {
		return estado;
	}
	
	/**
	 * Metodo que setea un valor en un atributo
	 * @param estado el valor del atributo en cuestion
	 */
	public void setEstado(String estado) {
		this.estado = estado;
	}

	/**
	 * Metodo que obtiene el objeto en cuestion de la clase
	 * @return el objeto buscado
	 */
	public Usuario getUsuario() {
		return usuario;
	}

	/**
	 * Metodo que setea un valor en un atributo
	 * @param usuario el valor del atributo en cuestion
	 */
	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

	/**
	 * Metodo que obtiene el objeto en cuestion de la clase
	 * @return el objeto buscado
	 */
	public TarjetaCredito getTarjetaCredito() {
		return tarjetaCredito;
	}

	/**
	 * Metodo que setea un valor en un atributo
	 * @param tarjetaCredito el valor del atributo en cuestion
	 */
	public void setTarjetaCredito(TarjetaCredito tarjetaCredito) {
		this.tarjetaCredito = tarjetaCredito;
	}

	/**
	 * Metodo que obtiene el objeto en cuestion de la clase
	 * @return el objeto buscado
	 */
	public DireccionEnvio getDireccionEnvio() {
		return direccionEnvio;
	}

	/**
	 * Metodo que setea un valor en un atributo
	 * @param direccionEnvio el valor del atributo en cuestion
	 */
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
