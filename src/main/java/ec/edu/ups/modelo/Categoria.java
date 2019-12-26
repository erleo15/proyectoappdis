package ec.edu.ups.modelo;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.NotEmpty;

/**
 * Clase para administrar los datos de la entidad categoria
 * a nivel de objetos
 * @author erleo15
 *
 */
@Entity(name="tie_categoria")
@Table(name="tie_categoria")
public class Categoria implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 4539278146825404479L;

	@Id
	@GeneratedValue
	@Column(name="cat_id")
	private int idCategoria;
	
	@NotNull
	@NotEmpty
	@Column(name = "cat_nombre")
	private String nombre;
	
	@NotNull
	@NotEmpty
	@Column(name = "cat_descripcion")
	private String descripcion;

	/**
	 * Metodo que obtiene el objeto en cuestion de la clase
	 * @return el objeto en cuestion
	 */
	public int getIdCategoria() {
		return idCategoria;
	}
	/**
	 * Metodo que setea el valor de dicho objeto en la clase
	 * @param idCategoria es el valor del atributo en cuestion
	 */
	public void setIdCategoria(int idCategoria) {
		this.idCategoria = idCategoria;
	}

	/**
	 * Metodo que obtiene el objeto en cuestion de la clase
	 * @return el objeto en cuestion
	 */
	public String getNombre() {
		return nombre;
	}

	/**
	 * Metodo que setea el valor de dicho objeto en la clase
	 * @param nombre es el valor del atributo en cuestion
	 */
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	/**
	 * Metodo que obtiene el objeto en cuestion de la clase
	 * @return el objeto en cuestion
	 */
	public String getDescripcion() {
		return descripcion;
	}

	/**
	 * Metodo que setea el valor de dicho objeto en la clase
	 * @param descripcion es el valor del atributo en cuestion
	 */
	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	@Override
	public String toString() {
		return "Categoria [idCategoria=" + idCategoria + ", nombre=" + nombre + ", descripcion=" + descripcion + "]";
	} 
	
}
