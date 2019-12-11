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
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.NotEmpty; 

@Entity(name="tie_usuario")
@Table(name="tie_usuario")
public class Usuario {
	
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

	public String getCedula() {
		return cedula;
	}

	public void setCedula(String cedula) {
		this.cedula = cedula;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getApellido() {
		return apellido;
	}

	public void setApellido(String apellido) {
		this.apellido = apellido;
	}

	public String getTelefono() {
		return telefono;
	}

	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Date getFechaNacimiento() {
		return fechaNacimiento;
	}

	public void setFechaNacimiento(Date fechaNacimiento) {
		this.fechaNacimiento = fechaNacimiento;
	}

	public Date getFechaRegistro() {
		return fechaRegistro;
	}

	public void setFechaRegistro(Date fechaRegistro) {
		this.fechaRegistro = fechaRegistro;
	}

	public String getUser() {
		return user;
	}

	public void setUser(String user) {
		this.user = user;
	}

	public String getContrasenia() {
		return contrasenia;
	}

	public void setContrasenia(String contrasenia) {
		this.contrasenia = contrasenia;
	}

	public int getNumeroCompra() {
		return numeroCompra;
	}

	public void setNumeroCompra(int numeroCompra) {
		this.numeroCompra = numeroCompra;
	}

	public double getDineroGastado() {
		return dineroGastado;
	}

	public void setDineroGastado(double dineroGastado) {
		this.dineroGastado = dineroGastado;
	}

	public String getDireccionUsuario() {
		return direccionUsuario;
	}

	public void setDireccionUsuario(String direccionUsuario) {
		this.direccionUsuario = direccionUsuario;
	}

	public String getTipoUsuario() {
		return tipoUsuario;
	}

	public void setTipoUsuario(String tipoUsuario) {
		this.tipoUsuario = tipoUsuario;
	}

	@Override
	public String toString() {
		return "Usuario [cedula=" + cedula + ", nombre=" + nombre + ", apellido=" + apellido + ", telefono=" + telefono
				+ ", email=" + email + ", fechaNacimiento=" + fechaNacimiento + ", fechaRegistro=" + fechaRegistro
				+ ", user=" + user + ", contrasenia=" + contrasenia + ", numeroCompra=" + numeroCompra
				+ ", dineroGastado=" + dineroGastado + ", direccionUsuario=" + direccionUsuario + ", tipoUsuario="
				+ tipoUsuario + "]";
	} 
	
	
}
