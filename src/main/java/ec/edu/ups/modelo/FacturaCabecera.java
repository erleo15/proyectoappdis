package ec.edu.ups.modelo;

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

@Entity
@Table(name="tie_fcabecera")
public class FacturaCabecera {

	@Id
	@Column(name="fcab_num_factura")
	private String numeroFactura;
	
	@NotNull
	@Column(name="fcab_fecha")
	@Temporal(TemporalType.TIMESTAMP)
	private Date fecha;
	
	
	@Column(name="fcab_subtotal",precision = 2)
	private double subtotal;
	
	@Column(name="fcab_iva",precision = 2)
	private double iva;
	
	@Column(name="fcab_total",precision = 2)
	private double total;
	
	@Column(name="fcab_estado")
	private String estado;
	
	@ManyToOne(cascade = {CascadeType.ALL}) 
	@JoinColumn(name = "fcab_cli_id",referencedColumnName = "cli_id")
	private Cliente cliente;

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

	public Cliente getCliente() {
		return cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	} 

	 
}
