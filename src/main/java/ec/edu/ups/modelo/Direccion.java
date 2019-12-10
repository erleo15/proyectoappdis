package ec.edu.ups.modelo;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="tie_direccion")
public class Direccion {

	@Id
	@Column(name = "dir_id")
	private int idDireccion;
	
	@Column(name="dir_calle")
	private String calle;
	
	@Column(name="dir_sector")
	private String sector;
	
	@Column(name="dir_num_casa")
	private String numeroCasa;
	
	@Column(name="dir_parroquia")
	private String parroquia;
	
	@Column(name="dir_ciudad")
	private String ciudad;
	
	@Column(name="dir_provincia")
	private String provincia;
	
	@Column(name="dir_codigo_postal")
	private String zipCode;
	
	
	
}
