package ec.edu.ups.modelo;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.NotEmpty; 

@Entity
@Table(name="tie_pelicula")
public class Pelicula implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -5809336894070167310L;

	@Id
	@GeneratedValue
	@Column(name="pel_id")
	private int codigoPelicula;
	
	@NotNull 
	@NotEmpty
	@Column(name="pel_nombre")
	private String nombre;
	
	@NotNull
	@NotEmpty
	@Column(name =  "pel_descripcion" , columnDefinition = "text")
	private String descripcion;
	
	@Column(name="pel_precio")
	private double precio;
	
	@Column(name="pel_anio")
	private int anio;
	
	@Column(name="pel_stock")
	private int stock;
	
	@Column(name="pel_cantidad_voto")
	private int cantidadVotos;
	
	@Column(name="pel_cantidad_venta")
	private int cantidadVentas;
	
	@NotNull
	@NotEmpty
	@Column(name="pel_img_http")
	private String imagenHttp;
	
	
	@NotNull
	@Column(name = "pel_cat_id")
	private int idCategoria;
	
	
	

	/**
	 * Metodo que obtiene el objeto en cuestion de la clase
	 * @return el objeto buscado
	 */
	public String getNombre() {
		return nombre;
	}

	/**
	 * Metodo que setea un valor en un atributo
	 * @param nombre el valor del atributo en cuestion
	 */
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	/**
	 * Metodo que obtiene el objeto en cuestion de la clase
	 * @return el objeto buscado
	 */
	public String getDescripcion() {
		return descripcion;
	}

	/**
	 * Metodo que setea un valor en un atributo
	 * @param descripcion el valor del atributo en cuestion
	 */
	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	/**
	 * Metodo que obtiene el objeto en cuestion de la clase
	 * @return el objeto buscado
	 */
	public double getPrecio() {
		return precio;
	}

	/**
	 * Metodo que setea un valor en un atributo
	 * @param precio el valor del atributo en cuestion
	 */
	public void setPrecio(double precio) {
		this.precio = precio;
	}
	/**
	 * Metodo que obtiene el objeto en cuestion de la clase
	 * @return el objeto buscado
	 */
	public int getAnio() {
		return anio;
	}

	/**
	 * Metodo que setea un valor en un atributo
	 * @param anio el valor del atributo en cuestion
	 */
	public void setAnio(int anio) {
		this.anio = anio;
	}

	/**
	 * Metodo que obtiene el objeto en cuestion de la clase
	 * @return el objeto buscado
	 */
	public int getStock() {
		return stock;
	}

	/**
	 * Metodo que setea un valor en un atributo
	 * @param stock el valor del atributo en cuestion
	 */
	public void setStock(int stock) {
		this.stock = stock;
	}

	/**
	 * Metodo que obtiene el objeto en cuestion de la clase
	 * @return el objeto buscado
	 */
	public int getCantidadVotos() {
		return cantidadVotos;
	}

	/**
	 * Metodo que setea un valor en un atributo
	 * @param cantidadVotos el valor del atributo en cuestion
	 */
	public void setCantidadVotos(int cantidadVotos) {
		this.cantidadVotos = cantidadVotos;
	}

	/**
	 * Metodo que obtiene el objeto en cuestion de la clase
	 * @return el objeto buscado
	 */
	public int getCantidadVentas() {
		return cantidadVentas;
	}

	/**
	 * Metodo que setea un valor en un atributo
	 * @param cantidadVentas el valor del atributo en cuestion
	 */
	public void setCantidadVentas(int cantidadVentas) {
		this.cantidadVentas = cantidadVentas;
	}

	/**
	 * Metodo que obtiene el objeto en cuestion de la clase
	 * @return el objeto buscado
	 */
	public String getImagenHttp() {
		return imagenHttp;
	}

	/**
	 * Metodo que setea un valor en un atributo
	 * @param imagenHttp el valor del atributo en cuestion
	 */
	public void setImagenHttp(String imagenHttp) {
		this.imagenHttp = imagenHttp;
	}

	 

	/**
	 * Metodo que obtiene el objeto en cuestion de la clase
	 * @return el objeto buscado
	 */
	public int getCodigoPelicula() {
		return codigoPelicula;
	}

	/**
	 * Metodo que setea un valor en un atributo
	 * @param codigoPelicula el valor del atributo en cuestion
	 */
	public void setCodigoPelicula(int codigoPelicula) {
		this.codigoPelicula = codigoPelicula;
	}

	public int getIdCategoria() {
		return idCategoria;
	}

	public void setIdCategoria(int idCategoria) {
		this.idCategoria = idCategoria;
	}

	@Override
	public String toString() {
		return "Pelicula [codigoPelicula=" + codigoPelicula + ", nombre=" + nombre + ", descripcion=" + descripcion
				+ ", precio=" + precio + ", anio=" + anio + ", stock=" + stock + ", cantidadVotos=" + cantidadVotos
				+ ", cantidadVentas=" + cantidadVentas + ", imagenHttp=" + imagenHttp + ", idCategoria=" + idCategoria
				+ "]";
	}

	

	
	
	
	 
}
