package ec.edu.ups.modelo;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id; 
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.NotEmpty; 

@Entity
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
	
	@Column(name="usu_direccion")
	private Direccion direccion;
	
	 
	
}
