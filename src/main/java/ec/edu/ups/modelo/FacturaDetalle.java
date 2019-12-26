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

@Entity(name="tie_fdetalle")
@Table(name="tie_fdetalle")
public class FacturaDetalle implements Serializable{

	@Id
	@GeneratedValue
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
	public int getTotalFDet() {
		return totalFDet;
	}

	/**
	 * Metodo que setea un valor en un atributo
	 * @param totalFDet el valor del atributo en cuestion
	 */
	public void setTotalFDet(int totalFDet) {
		this.totalFDet = totalFDet;
	}

	/**
	 * Metodo que obtiene el objeto en cuestion de la clase
	 * @return el objeto buscado
	 */
	public FacturaCabecera getfCabecera() {
		return fCabecera;
	}
	/**
	 * Metodo que setea un valor en un atributo
	 * @param fCabecera el valor del atributo en cuestion
	 */

	public void setfCabecera(FacturaCabecera fCabecera) {
		this.fCabecera = fCabecera;
	}

	/**
	 * Metodo que obtiene el objeto en cuestion de la clase
	 * @return el objeto buscado
	 */
	public Pelicula getPelicula() {
		return pelicula;
	}

	/**
	 * Metodo que setea un valor en un atributo
	 * @param pelicula el valor del atributo en cuestion
	 */
	public void setPelicula(Pelicula pelicula) {
		this.pelicula = pelicula;
	}

	@Override
	public String toString() {
		return "FacturaDetalle [numFDetalle=" + numFDetalle + ", cantidad=" + cantidad + ", totalFDet=" + totalFDet
				+ ", fCabecera=" + fCabecera + ", pelicula=" + pelicula + "]";
	}

	

	 
}
