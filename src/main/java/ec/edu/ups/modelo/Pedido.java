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

	public int getNum_pedido() {
		return num_pedido;
	}

	public void setNum_pedido(int num_pedido) {
		this.num_pedido = num_pedido;
	}

	public Date getFechaEntrega() {
		return fechaEntrega;
	}

	public void setFechaEntrega(Date fechaEntrega) {
		this.fechaEntrega = fechaEntrega;
	}

	public String getEstado() {
		return estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}

	public FacturaCabecera getFacturaCabecera() {
		return facturaCabecera;
	}

	public void setFacturaCabecera(FacturaCabecera facturaCabecera) {
		this.facturaCabecera = facturaCabecera;
	}

	public Tienda getTienda() {
		return tienda;
	}

	public void setTienda(Tienda tienda) {
		this.tienda = tienda;
	}

	@Override
	public String toString() {
		return "Pedido [num_pedido=" + num_pedido + ", fechaEntrega=" + fechaEntrega + ", estado=" + estado
				+ ", facturaCabecera=" + facturaCabecera + ", tienda=" + tienda + "]";
	}
	
	
	
}
