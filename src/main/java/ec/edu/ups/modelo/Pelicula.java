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
import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.NotEmpty; 

@Entity(name="tie_pelicula")
@Table(name="tie_pelicula")
public class Pelicula implements Serializable{
	
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
	@Column(name =  "pel_descripcion")
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
	
	@ManyToOne(cascade = {CascadeType.ALL}) 
	@JoinColumn(name = "pel_cat_id",referencedColumnName = "cat_id")
	private Categoria categoria;
	
	/*
	@ManyToOne(cascade = {CascadeType.ALL}) 
	@JoinColumn(name = "pel_tie_id",referencedColumnName = "tie_id")
	private Tienda tienda;*/


	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public double getPrecio() {
		return precio;
	}

	public void setPrecio(double precio) {
		this.precio = precio;
	}

	public int getAnio() {
		return anio;
	}

	public void setAnio(int anio) {
		this.anio = anio;
	}

	public int getStock() {
		return stock;
	}

	public void setStock(int stock) {
		this.stock = stock;
	}

	public int getCantidadVotos() {
		return cantidadVotos;
	}

	public void setCantidadVotos(int cantidadVotos) {
		this.cantidadVotos = cantidadVotos;
	}

	public int getCantidadVentas() {
		return cantidadVentas;
	}

	public void setCantidadVentas(int cantidadVentas) {
		this.cantidadVentas = cantidadVentas;
	}

	public String getImagenHttp() {
		return imagenHttp;
	}

	public void setImagenHttp(String imagenHttp) {
		this.imagenHttp = imagenHttp;
	}

	public Categoria getCategoria() {
		return categoria;
	}

	public void setCategoria(Categoria categoria) {
		this.categoria = categoria;
	}

	public int getCodigoPelicula() {
		return codigoPelicula;
	}

	public void setCodigoPelicula(int codigoPelicula) {
		this.codigoPelicula = codigoPelicula;
	}

	/*
	public Tienda getTienda() {
		return tienda;
	}

	public void setTienda(Tienda tienda) {
		this.tienda = tienda;
	}
*/
	

	
	
	
	 
}
