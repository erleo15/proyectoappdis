package ec.edu.ups.modelo;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="tie_fdetalle")
public class FacturaDetalle {

	@Id
	@Column(name="fdet_numero")
	private int numFDetalle;
	
	@Column(name="fdet_cantidad")
	private int cantidad;
	
	@Column(name="fdet_total")
	private int totalFDet;
	
	@ManyToOne(cascade = {CascadeType.ALL}) 
	@JoinColumn(name = "fdet_fcab_num_factura",referencedColumnName = "fcab_num_factura")
	private FacturaCabecera fCabecera;
	
	@ManyToOne(cascade = {CascadeType.ALL}) 
	@JoinColumn(name = "fdet_pel_id",referencedColumnName = "pel_id")
	private Pelicula pelicula;

	public int getNumFDetalle() {
		return numFDetalle;
	}

	public void setNumFDetalle(int numFDetalle) {
		this.numFDetalle = numFDetalle;
	}

	public int getCantidad() {
		return cantidad;
	}

	public void setCantidad(int cantidad) {
		this.cantidad = cantidad;
	}

	public int getTotalFDet() {
		return totalFDet;
	}

	public void setTotalFDet(int totalFDet) {
		this.totalFDet = totalFDet;
	}

	public FacturaCabecera getfCabecera() {
		return fCabecera;
	}

	public void setfCabecera(FacturaCabecera fCabecera) {
		this.fCabecera = fCabecera;
	}

	public Pelicula getPelicula() {
		return pelicula;
	}

	public void setPelicula(Pelicula pelicula) {
		this.pelicula = pelicula;
	}

	@Override
	public String toString() {
		return "FacturaDetalle [numFDetalle=" + numFDetalle + ", cantidad=" + cantidad + ", totalFDet=" + totalFDet
				+ ", fCabecera=" + fCabecera + ", pelicula=" + pelicula + "]";
	}

	

	 
}
