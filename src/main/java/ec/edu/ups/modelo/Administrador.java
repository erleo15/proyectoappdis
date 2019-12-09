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

@Entity
@Table(name = "tie_administrador")
public class Administrador {
	@Id
	@Column(name="adm_id")
	private int idAdministrador;
	
	@Temporal(TemporalType.DATE)
	@Column(name="adm_fecha_ingreso")
	private Date fechaIngreso;//jiji
	
	@Temporal(TemporalType.DATE)
	@Column(name="adm_fecha_baja")
	private Date fechaBaja;
	
	@ManyToOne(cascade = {CascadeType.ALL})
	@JoinColumn(name = "adm_per_cedula",referencedColumnName = "per_cedula")
	private Persona persona;

	public int getIdAdministrador() {
		return idAdministrador;
	}

	public void setIdAdministrador(int idAdministrador) {
		this.idAdministrador = idAdministrador;
	}

	public Date getFechaIngreso() {
		return fechaIngreso;
	}

	public void setFechaIngreso(Date fechaIngreso) {
		this.fechaIngreso = fechaIngreso;
	}

	public Date getFechaBaja() {
		return fechaBaja;
	}

	public void setFechaBaja(Date fechaBaja) {
		this.fechaBaja = fechaBaja;
	}

	public Persona getPersona() {
		return persona;
	}

	public void setPersona(Persona persona) {
		this.persona = persona;
	}

	
}
