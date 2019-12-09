package ec.edu.ups.modelo;

import java.util.Date; 

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id; 
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType; 
import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.NotEmpty; 

@Entity
@Table(name="tie_persona")
public class Persona {
	
	
	

	@Id
	@Column(name="per_cedula",length = 10)
	private String cedula;
	
	@NotNull
	@NotEmpty
	@Column(name="per_nombre")
	private String nombre;
	
	@NotNull
	@NotEmpty
	@Column(name="per_apellido")
	private String apellido;
	
	@Column(name="per_telefono")
	private String telefono;
	
	@Email
	@NotNull 
	@Column(name="per_email",unique = true)
	private String email;
	
	@Column(name="per_direccion")
	private String direccion;
	
	@NotNull
	@Temporal(TemporalType.DATE)
	@Column(name="per_fecha_nacimiento")
	private Date fechaNacimiento;
	
	@NotNull
	@Temporal(TemporalType.DATE)
	@Column(name="per_fecha_registro")
	private Date fechaRegistro;
	
	@NotNull
	@Column(name="per_user",unique = true)
	private String user;
	
	@NotNull
	@Column(name="per_contrasenia")
	private String contrasenia;

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

	public String getDireccion() {
		return direccion;
	}

	public void setDireccion(String direccion) {
		this.direccion = direccion;
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
	
	@Override
	public String toString() {
		return "Persona [cedula=" + cedula + ", nombre=" + nombre + ", apellido=" + apellido + ", telefono=" + telefono
				+ ", email=" + email + ", direccion=" + direccion + ", fechaNacimiento=" + fechaNacimiento
				+ ", fechaRegistro=" + fechaRegistro + ", user=" + user + ", contrasenia=" + contrasenia + "]";
	}
	
	

	 
}
