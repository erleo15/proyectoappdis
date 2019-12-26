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

@Entity(name="tie_pedido")
@Table(name="tie_pedido")
public class Pedido implements Serializable{

	@Id
	@GeneratedValue
	@Column(name="ped_numero")
	private int num_pedido;
	
	@Temporal(TemporalType.DATE)
	@Column(name="ped_fentrega")
	private Date fechaEntrega;
	
	@Column(name="ped_estado")
	private String estado;
	
	@ManyToOne(cascade = {CascadeType.ALL}) 
	@JoinColumn(name = "ped_fcab_num_factura", referencedColumnName = "fcab_num_factura")
	private FacturaCabecera facturaCabecera;
	
	@ManyToOne(cascade = {CascadeType.ALL}) 
	@JoinColumn(name = "ped_tie_id",referencedColumnName = "tie_id")
	private Tienda tienda;

	/**
	 * Metodo que obtiene el objeto en cuestion de la clase
	 * @return el objeto buscado
	 */
	public int getNum_pedido() {
		return num_pedido;
	}

	/**
	 * Metodo que setea un valor en un atributo
	 * @param num_pedido el valor del atributo en cuestion
	 */
	public void setNum_pedido(int num_pedido) {
		this.num_pedido = num_pedido;
	}

	/**
	 * Metodo que obtiene el objeto en cuestion de la clase
	 * @return el objeto buscado
	 */
	public Date getFechaEntrega() {
		return fechaEntrega;
	}

	/**
	 * Metodo que setea un valor en un atributo
	 * @param fechaEntrega el valor del atributo en cuestion
	 */
	public void setFechaEntrega(Date fechaEntrega) {
		this.fechaEntrega = fechaEntrega;
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
	public FacturaCabecera getFacturaCabecera() {
		return facturaCabecera;
	}

	/**
	 * Metodo que setea un valor en un atributo
	 * @param facturaCabecera el valor del atributo en cuestion
	 */
	public void setFacturaCabecera(FacturaCabecera facturaCabecera) {
		this.facturaCabecera = facturaCabecera;
	}

	/**
	 * Metodo que obtiene el objeto en cuestion de la clase
	 * @return el objeto buscado
	 */
	public Tienda getTienda() {
		return tienda;
	}

	/**
	 * Metodo que setea un valor en un atributo
	 * @param tienda el valor del atributo en cuestion
	 */
	public void setTienda(Tienda tienda) {
		this.tienda = tienda;
	}

	@Override
	public String toString() {
		return "Pedido [num_pedido=" + num_pedido + ", fechaEntrega=" + fechaEntrega + ", estado=" + estado
				+ ", facturaCabecera=" + facturaCabecera + ", tienda=" + tienda + "]";
	}
	
	
	
}
