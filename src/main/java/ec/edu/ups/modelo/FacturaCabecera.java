package ec.edu.ups.modelo;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;

@Entity
@Table(name="tie_fcabecera")
public class FacturaCabecera implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1569947904429904117L;

	@Id 
	@GeneratedValue
	@Column(name="fcab_num_factura")
	private int numeroFactura;
	
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
	
	@Column(name = "fcab_numero_tarjeta")
	private String  numeroTarjetaCredito;
	
	@Column(name = "fcab_direccion")
	private String direccionEnvio;
	
	@Column(name = "fcab_usu_cedula")
	private String cedulaUsuario;
	 
	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	@JoinColumn(name = "fdet_fcab_num_factura")
	private List<FacturaDetalle> listaFacturaDetalle;
	 
	

	/**
	 * Metodo que obtiene el objeto en cuestion de la clase
	 * @return el objeto buscado
	 */
	public int getNumeroFactura() {
		return numeroFactura;
	}

	/**
	 * Metodo que setea un valor en un atributo
	 * @param numeroFactura el valor del atributo en cuestion
	 */
	public void setNumeroFactura(int numeroFactura) {
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
	public String getCedulaUsuario() {
		return cedulaUsuario;
	}

	/**
	 * Metodo que setea un valor en un atributo
	 * @param usuario el valor del atributo en cuestion
	 */
	public void setCedulaUsuario(String cedulaUsuario) {
		this.cedulaUsuario = cedulaUsuario;
	}

	/**
	 * Metodo que obtiene el objeto en cuestion de la clase
	 * @return el objeto buscado
	 */
	public String getDireccionEnvio() {
		return direccionEnvio;
	}

	/**
	 * Metodo que setea un valor en un atributo
	 * @param direccionEnvio el valor del atributo en cuestion
	 */
	public void setDireccionEnvio(String direccionEnvio) {
		this.direccionEnvio = direccionEnvio;
	}

	public String getNumeroTarjetaCredito() {
		return numeroTarjetaCredito;
	}

	public void setNumeroTarjetaCredito(String numeroTarjetaCredito) {
		this.numeroTarjetaCredito = numeroTarjetaCredito;
	}

	public List<FacturaDetalle> getListaFacturaDetalle() {
		return listaFacturaDetalle;
	}

	public void setListaFacturaDetalle(List<FacturaDetalle> listaFacturaDetalle) {
		this.listaFacturaDetalle = listaFacturaDetalle;
	}

	@Override
	public String toString() {
		return "FacturaCabecera [numeroFactura=" + numeroFactura + ", fecha=" + fecha + ", subtotal=" + subtotal
				+ ", descuento=" + descuento + ", iva=" + iva + ", total=" + total + ", estado=" + estado
				+ ", numeroTarjetaCredito=" + numeroTarjetaCredito + ", direccionEnvio=" + direccionEnvio
				+ ", cedulaUsuario=" + cedulaUsuario + ", listaFacturaDetalle=" + listaFacturaDetalle + "]";
	}

	 
}
