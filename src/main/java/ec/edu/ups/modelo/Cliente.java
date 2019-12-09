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
@Table(name="tie_cliente")
public class Cliente {
	
	@Id
	@Column(name="cli_id")
	private int idCliente;
	
	@NotNull
	@Column(name="cli_num_compra")
	private int numeroCompras;
	
	@ManyToOne(cascade = {CascadeType.ALL})
	@JoinColumn(name="cli_usu_id",referencedColumnName = "usu_id")
	private Usuario usuario;
	
	@ManyToOne(cascade = {CascadeType.ALL})
	@JoinColumn(name="cli_tar_numero",referencedColumnName = "tar_numero")
	private TarjetaCredito tarjetaCredito;

	public int getIdCliente() {
		return idCliente;
	}

	public void setIdCliente(int idCliente) {
		this.idCliente = idCliente;
	}

	public int getNumeroCompras() {
		return numeroCompras;
	}

	public void setNumeroCompras(int numeroCompras) {
		this.numeroCompras = numeroCompras;
	}

	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

	public TarjetaCredito getTarjetaCredito() {
		return tarjetaCredito;
	}

	public void setTarjetaCredito(TarjetaCredito tarjetaCredito) {
		this.tarjetaCredito = tarjetaCredito;
	}

	 
	
}
