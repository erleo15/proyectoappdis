package ec.edu.ups.modelo;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column; 
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.NotEmpty;

import com.fasterxml.jackson.annotation.JsonIgnore; 

/**
 * Clase que representa al modelo usuario
 * en la base de datos
 * @author erleo15
 *
 */
@Entity
@Table(name="tie_usuario")
//@Proxy(lazy = false)
public class Usuario implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 7057804588943771436L;

	@Id
	@Column(name="usu_cedula",length = 10)
	private String cedula;
	
	@NotNull
	@NotEmpty
	@Column(name="usu_nombre")
	private String nombre;
	
	@NotNull
	@NotEmpty
	@Column(name="usu_apellido")
	private String apellido;
	
	@Size(min = 7,max = 14)
	@Column(name="usu_telefono")
	private String telefono;
	
	@Email
	@NotNull 
	@Column(name="usu_email",unique = true)
	private String email;
	
	@NotNull
	@Temporal(TemporalType.DATE)
	@Column(name="usu_fecha_nacimiento")
	private Date fechaNacimiento;
	
	@NotNull
	@Temporal(TemporalType.DATE)
	@Column(name="usu_fecha_registro")
	private Date fechaRegistro;
	
	@NotNull
	@Column(name="usu_user",unique = true)
	private String user;
	
	@NotNull
	@Column(name="usu_contrasenia")
	private String contrasenia;
	
	@NotNull
	@Column(name="usu_num_compra")
	private int numeroCompra;
	
	@NotNull
	@Column(name="usu_dinero_gastado")
	private double dineroGastado;
	 
	@NotNull
	@Column(name="usu_direccion")
	private String direccionUsuario;
	
	@Column(name = "usu_tipo")
	private String tipoUsuario;
	
	@JsonIgnore
	@OneToMany(cascade = CascadeType.ALL,fetch = FetchType.LAZY)
	@JoinColumn(name = "fcab_usu_cedula")  
	private List<FacturaCabecera> listaFacturaCabecera = new ArrayList<>();
	
	@OneToMany(cascade = CascadeType.ALL,fetch = FetchType.EAGER)
	@JoinColumn(name = "car_usu_cedula")  
	private List<Carrito> listaCarrito = new ArrayList<>();

	
	/**
	 * metodo que obtine un atributo especifico
	 * @return el atributo en cuestion
	 */
	public String getCedula() {
		return cedula;
	}
	/**
	 *Metodo que setea un valor a un atributo
	 *especifico de la clase
	 * @param cedula el es parametro a setearse en 
	 * el atributo
	 */
	public void setCedula(String cedula) {
		this.cedula = cedula;
	}
	/**
	 * metodo que obtine un atributo especifico
	 * @return el atributo en cuestion
	 */
	public String getNombre() {
		return nombre;
	}

	/**
	 *Metodo que setea un valor a un atributo
	 *especifico de la clase
	 * @param nombre el es parametro a setearse en 
	 * el atributo
	 */
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	/**
	 * metodo que obtine un atributo especifico
	 * @return el atributo en cuestion
	 */
	public String getApellido() {
		return apellido;
	}

	
	/**
	 *Metodo que setea un valor a un atributo
	 *especifico de la clase
	 * @param apellido el es parametro a setearse en 
	 * el atributo
	 */
	public void setApellido(String apellido) {
		this.apellido = apellido;
	}

	/**
	 * metodo que obtine un atributo especifico
	 * @return el atributo en cuestion
	 */
	public String getTelefono() {
		return telefono;
	}

	/**
	 *Metodo que setea un valor a un atributo
	 *especifico de la clase
	 * @param telefono el es parametro a setearse en 
	 * el atributo
	 */
	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}

	/**
	 * metodo que obtine un atributo especifico
	 * @return el atributo en cuestion
	 */
	public String getEmail() {
		return email;
	}

	/**
	 *Metodo que setea un valor a un atributo
	 *especifico de la clase
	 * @param email el es parametro a setearse en 
	 * el atributo
	 */
	public void setEmail(String email) {
		this.email = email;
	}

	/**
	 * metodo que obtine un atributo especifico
	 * @return el atributo en cuestion
	 */
	public Date getFechaNacimiento() {
		return fechaNacimiento;
	}

	/**
	 *Metodo que setea un valor a un atributo
	 *especifico de la clase
	 * @param fechaNacimiento el es parametro a setearse en 
	 * el atributo
	 */
	public void setFechaNacimiento(Date fechaNacimiento) {
		this.fechaNacimiento = fechaNacimiento;
	}

	/**
	 * metodo que obtine un atributo especifico
	 * @return el atributo en cuestion
	 */
	public Date getFechaRegistro() {
		return fechaRegistro;
	}

	/**
	 *Metodo que setea un valor a un atributo
	 *especifico de la clase
	 * @param fechaRegistro el es parametro a setearse en 
	 * el atributo
	 */
	public void setFechaRegistro(Date fechaRegistro) {
		this.fechaRegistro = fechaRegistro;
	}

	/**
	 * metodo que obtine un atributo especifico
	 * @return el atributo en cuestion
	 */
	public String getUser() {
		return user;
	}

	/**
	 *Metodo que setea un valor a un atributo
	 *especifico de la clase
	 * @param user el es parametro a setearse en 
	 * el atributo
	 */
	public void setUser(String user) {
		this.user = user;
	}

	/**
	 * metodo que obtine un atributo especifico
	 * @return el atributo en cuestion
	 */
	public String getContrasenia() {
		return contrasenia;
	}

	/**
	 *Metodo que setea un valor a un atributo
	 *especifico de la clase
	 * @param contrasenia el es parametro a setearse en 
	 * el atributo
	 */
	public void setContrasenia(String contrasenia) {
		this.contrasenia = contrasenia;
	}

	/**
	 * metodo que obtine un atributo especifico
	 * @return el atributo en cuestion
	 */
	public int getNumeroCompra() {
		return numeroCompra;
	}

	/**
	 *Metodo que setea un valor a un atributo
	 *especifico de la clase
	 * @param numeroCompra el es parametro a setearse en 
	 * el atributo
	 */
	public void setNumeroCompra(int numeroCompra) {
		this.numeroCompra = numeroCompra;
	}
	
	/**
	 * metodo que obtine un atributo especifico
	 * @return el atributo en cuestion
	 */
	public double getDineroGastado() {
		return dineroGastado;
	}

	/**
	 *Metodo que setea un valor a un atributo
	 *especifico de la clase
	 * @param dineroGastado el es parametro a setearse en 
	 * el atributo
	 */
	public void setDineroGastado(double dineroGastado) {
		this.dineroGastado = dineroGastado;
	}

	/**
	 * metodo que obtine un atributo especifico
	 * @return el atributo en cuestion
	 */
	public String getDireccionUsuario() {
		return direccionUsuario;
	}

	/**
	 *Metodo que setea un valor a un atributo
	 *especifico de la clase
	 * @param direccionUsuario el es parametro a setearse en 
	 * el atributo
	 */
	public void setDireccionUsuario(String direccionUsuario) {
		this.direccionUsuario = direccionUsuario;
	}

	/**
	 * metodo que obtine un atributo especifico
	 * @return el atributo en cuestion
	 */
	public String getTipoUsuario() {
		return tipoUsuario;
	}

	/**
	 *Metodo que setea un valor a un atributo
	 *especifico de la clase
	 * @param tipoUsuario el es parametro a setearse en 
	 * el atributo
	 */
	public void setTipoUsuario(String tipoUsuario) {
		this.tipoUsuario = tipoUsuario;
	}

	public List<FacturaCabecera> getListaFacturaCabecera() {
		return listaFacturaCabecera;
	}
	public void setListaFacturaCabecera(List<FacturaCabecera> listaFacturaCabecera) {
		this.listaFacturaCabecera = listaFacturaCabecera;
	}
	public List<Carrito> getListaCarrito() {
		return listaCarrito;
	}
	public void setListaCarrito(List<Carrito> listaCarrito) {
		this.listaCarrito = listaCarrito;
	}
	
	@Override
	public String toString() {
		return "Usuario [cedula=" + cedula + ", nombre=" + nombre + ", apellido=" + apellido + ", telefono=" + telefono
				+ ", email=" + email + ", fechaNacimiento=" + fechaNacimiento + ", fechaRegistro=" + fechaRegistro
				+ ", user=" + user + ", contrasenia=" + contrasenia + ", numeroCompra=" + numeroCompra
				+ ", dineroGastado=" + dineroGastado + ", direccionUsuario=" + direccionUsuario + ", tipoUsuario="
				+ tipoUsuario //+ ", listaFacturaCabecera=" + listaFacturaCabecera 
				+ ", listaCarrito=" + listaCarrito
				+ "]";
	} 
	
	
}
