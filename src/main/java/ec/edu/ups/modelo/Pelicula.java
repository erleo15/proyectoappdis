package ec.edu.ups.modelo;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull; 

@Entity
@Table(name="tie_pelicula")
public class Pelicula {
	
	@Id
	@Column(name="pel_id")
	private int codigoProducto;
	
	@NotNull 
	@Column(name="pel_nombre")
	private String nombre;
	
	@NotNull
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
	
	@Column(name="pel_img_http")
	private String imagenHttp;
	
	@ManyToOne(cascade = {CascadeType.ALL}) 
	@JoinColumn(name = "pel_cat_id",referencedColumnName = "cat_id")
	private Categoria categoria;

	public int getCodigoProducto() {
		return codigoProducto;
	}

	public void setCodigoProducto(int codigoProducto) {
		this.codigoProducto = codigoProducto;
	}

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

	@Override
	public String toString() {
		return "Pelicula [codigoProducto=" + codigoProducto + ", nombre=" + nombre + ", descripcion=" + descripcion
				+ ", precio=" + precio + ", anio=" + anio + ", stock=" + stock + ", cantidadVotos=" + cantidadVotos
				+ ", cantidadVentas=" + cantidadVentas + ", imagenHttp=" + imagenHttp + ", categoria=" + categoria
				+ "]";
	}
	
	
	
}
