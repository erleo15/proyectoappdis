package ec.edu.ups.modelo;

import java.io.Serializable;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull; 

@Entity
@Table(name="tie_fdetalle")
public class FacturaDetalle implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 3958982004501004158L;

	@Id
	@GeneratedValue
	@Column(name="fdet_numero")
	private int numFDetalle;
	
	@Column(name="fdet_cantidad")
	private int cantidad;
	
	@Column(name="fdet_total")
	private double totalFDet;
	
	//@NotNull
	@Column(name="fdet_fcab_num_factura")
	private int numeroFactura;
	
	//@JsonIgnore
	//NotNull 
	//@ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	//@JoinColumn(name="fdet_pel_id")
	//@Column(name="fdet_pel_id")
	//private int  idPelicula;
	
	@NotNull
	@ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	@JoinColumn(name="fdet_pel_id")
	private Pelicula pelicula;
	

	/**
	 * Metodo que obtiene el objeto en cuestion de la clase
	 * @return el objeto buscado
	 */
	public int getNumFDetalle() {
		return numFDetalle;
	}

	/**
	 * Metodo que setea un valor en un atributo
	 * @param numFDetalle el valor del atributo en cuestion
	 */
	public void setNumFDetalle(int numFDetalle) {
		this.numFDetalle = numFDetalle;
	}

	/**
	 * Metodo que obtiene el objeto en cuestion de la clase
	 * @return el objeto buscado
	 */
	public int getCantidad() {
		return cantidad;
	}

	/**
	 * Metodo que setea un valor en un atributo
	 * @param cantidad el valor del atributo en cuestion
	 */
	public void setCantidad(int cantidad) {
		this.cantidad = cantidad;
	}

	/**
	 * Metodo que obtiene el objeto en cuestion de la clase
	 * @return el objeto buscado
	 */
	public double getTotalFDet() {
		return totalFDet;
	}

	/**
	 * Metodo que setea un valor en un atributo
	 * @param totalFDet el valor del atributo en cuestion
	 */
	public void setTotalFDet(double totalFDet) {
		this.totalFDet = totalFDet;
	}

	public int getNumeroFactura() {
		return numeroFactura;
	}

	public void setNumeroFactura(int numeroFactura) {
		this.numeroFactura = numeroFactura;
	}

	public Pelicula getPelicula() {
		return this.pelicula;
	}

	public void setPelicula(Pelicula pelicula) {
		this.pelicula = pelicula;
	}

	@Override
	public String toString() {
		return "FacturaDetalle [numFDetalle=" + numFDetalle + ", cantidad=" + cantidad + ", totalFDet=" + totalFDet
				+ ", numeroFactura=" + numeroFactura + ", Pelicula=" + pelicula + "]";
	}



	 
	 
}
