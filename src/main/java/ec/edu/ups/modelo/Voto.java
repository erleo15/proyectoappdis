package ec.edu.ups.modelo;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "tie_voto")
public class Voto  implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -4369766911446387774L;

	@Id
	@Column(name = "vot_id")
	private int idVoto;
	
	 
	@Column(name = "vot_usu_cedula")
	private String cedulaUsuario;
	
	 
	@Column(name = "vot_pel_id")
	private int idPelicula;

	
	/**
	 * Metodo que retorna un parametro de la clase
	 * @return parametro en cuestion
	 */
	public int getIdVoto() {
		return idVoto;
	}
	
	/**
	 * Metodo que setea un parametro de la clase
	 * @param idVoto atributo a seterse
	 */
	public void setIdVoto(int idVoto) {
		this.idVoto = idVoto;
	}
	
	/**
	 * Metodo que obtiene un atributo de la clase
	 * @return parametro en cuestion
	 */
	public String getCedulaUsuario() {
		return cedulaUsuario;
	}

	/**
	 * Metodo que setea un parametro de la clase
	 * @param cedulaUsuario parametro en cuestion
	 */
	public void setCedulaUsuario(String cedulaUsuario) {
		this.cedulaUsuario = cedulaUsuario;
	}
	
	/**
	 * Metodo que obtiene un parametro de una clase
	 * @return parametro en cuestion
	 */
	public int getIdPelicula() {
		return idPelicula;
	}
	
	/**
	 * Metodo que setea un parametro en la clase
	 * @param idPelicula parametro en cuestion 
	 */
	public void setIdPelicula(int idPelicula) {
		this.idPelicula = idPelicula;
	}



	@Override
	public String toString() {
		return "Voto [idVoto=" + idVoto + ", cedulaUsuario=" + cedulaUsuario + ", idPelicula=" + idPelicula + "]";
	}


}
