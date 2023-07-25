package model;

import javax.persistence.*;

@Entity
public class Propietario {
	
	
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id_propietario;
	

	private String numero_documento;
	
	private String nit;

	private String razon_social;
	
	private String direccion;
	
	private String telefono;

	private String correo_electronico;
	
	private Boolean estado;
	
	@OneToOne
	@JoinColumn(name="id_tipo_documento")
	private Tipo_documento id_tipo_documento;
	
	@OneToOne
	@JoinColumn(name="id_tipo_persona")
	private Tipo_persona id_tipo_persona;

	public Integer getId_propietario() {
		return id_propietario;
	}

	public void setId_propietario(Integer id_propietario) {
		this.id_propietario = id_propietario;
	}


	public String getNumero_documento() {
		return numero_documento;
	}

	public void setNumero_documento(String numero_documento) {
		this.numero_documento = numero_documento;
	}

	public String getNit() {
		return nit;
	}

	public void setNit(String nit) {
		this.nit = nit;
	}

	public String getRazon_social() {
		return razon_social;
	}

	public void setRazon_social(String razon_social) {
		this.razon_social = razon_social;
	}

	public String getDireccion() {
		return direccion;
	}

	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}

	public String getTelefono() {
		return telefono;
	}

	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}

	public String getCorreo_electronico() {
		return correo_electronico;
	}

	public void setCorreo_electronico(String correo_electronico) {
		this.correo_electronico = correo_electronico;
	}

	public Boolean getEstado() {
		return estado;
	}

	public void setEstado(Boolean estado) {
		this.estado = estado;
	}

	public Tipo_documento getId_tipo_documento() {
		return id_tipo_documento;
	}

	public void setId_tipo_documento(Tipo_documento id_tipo_documento) {
		this.id_tipo_documento = id_tipo_documento;
	}

	public Tipo_persona getId_tipo_persona() {
		return id_tipo_persona;
	}

	public void setId_tipo_persona(Tipo_persona id_tipo_persona) {
		this.id_tipo_persona = id_tipo_persona;
	}


	
	
	
	
}
