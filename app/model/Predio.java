package model;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.*;

@Entity
public class Predio {
	
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer numero_predial;
	
	private Double avaluo;
	
	private String nombre;
	
	private String departamento;
	
	private String municipio;
	
	private Boolean estado;
	
	@OneToOne
	@JoinColumn(name="id_terreno")
	private Terreno terreno;
	
	
    @JoinTable(name = "construccionpredio",
            joinColumns = @JoinColumn(name = "numero_predial"),
            inverseJoinColumns = @JoinColumn(name = "id_construccion")
    )
    @ManyToMany(cascade = CascadeType.ALL,fetch = FetchType.EAGER)
    private Set<Construccion> construcciones = new HashSet<Construccion>();
    
    @JoinTable(name = "propietariopredio",
            joinColumns = @JoinColumn(name = "id_predio"),
            inverseJoinColumns = @JoinColumn(name = "id_propietario")
    )
    @ManyToMany(cascade = CascadeType.ALL,fetch = FetchType.EAGER)
    private Set<Propietario> propietarios = new HashSet<Propietario>();


	public Integer getNumero_predial() {
		return numero_predial;
	}

	public void setNumero_predial(Integer numero_predial) {
		this.numero_predial = numero_predial;
	}

	public Double getAvaluo() {
		return avaluo;
	}

	public void setAvaluo(Double avaluo) {
		this.avaluo = avaluo;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getDepartamento() {
		return departamento;
	}

	public void setDepartamento(String departamento) {
		this.departamento = departamento;
	}

	public String getMunicipio() {
		return municipio;
	}

	public void setMunicipio(String municipio) {
		this.municipio = municipio;
	}

	public Boolean getEstado() {
		return estado;
	}

	public void setEstado(Boolean estado) {
		this.estado = estado;
	}

	public Terreno getTerreno() {
		return terreno;
	}

	public void setTerreno(Terreno terreno) {
		this.terreno = terreno;
	}
	
	public Set<Construccion> getConstrucciones() {
		return construcciones;
	}

	public void setConstrucciones(Set<Construccion> construcciones) {
		this.construcciones = construcciones;
	}

	public Set<Propietario> getPropietarios() {
		return propietarios;
	}

	public void setPropietarios(Set<Propietario> propietarios) {
		this.propietarios = propietarios;
	}
	

}
