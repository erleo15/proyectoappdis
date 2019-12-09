package ec.edu.ups.modelo;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="tie_usuario")
public class Usuario {
	
	@Id
	@Column(name="usu_id")
	private int idUsuario; 
	
	@ManyToOne(cascade = {CascadeType.ALL})
	@JoinColumn(name = "usu_per_cedula",referencedColumnName = "per_cedula")
	private Persona persona;

	public int getIdUsuario() {
		return idUsuario;
	}

	public void setIdUsuario(int idUsuario) {
		this.idUsuario = idUsuario;
	}

	public Persona getPersona() {
		return persona;
	}

	public void setPersona(Persona persona) {
		this.persona = persona;
	}

	@Override
	public String toString() {
		return "Usuario [idUsuario=" + idUsuario + ", persona=" + persona + "]";
	}
	
	
}
