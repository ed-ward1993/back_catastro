package model;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
public class Construccion {
	
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id_construccion;
	
	private Integer numero_pisos;
	
	private Double area_total;
	
	private String direccion_construccion;
	
	private Boolean estado;
	
	@OneToOne
	@JoinColumn(name="id_tipo_construccion")
	private Tipo_construccion id_tipo_construccion;
	/*
	
	@JsonIgnoreProperties("construcciones")
	@ManyToMany(mappedBy = "construcciones", fetch = FetchType.EAGER)
	private Set<Predio> predios = new HashSet<Predio>();
	*/

	public Integer getId_construccion() {
		return id_construccion;
	}

	public void setId_construccion(Integer id_construccion) {
		this.id_construccion = id_construccion;
	}

	public Integer getNumero_pisos() {
		return numero_pisos;
	}

	public void setNumero_pisos(Integer numero_pisos) {
		this.numero_pisos = numero_pisos;
	}

	public Double getArea_total() {
		return area_total;
	}

	public void setArea_total(Double area_total) {
		this.area_total = area_total;
	}

	public String getDireccion_construccion() {
		return direccion_construccion;
	}

	public void setDireccion_construccion(String direccion_construccion) {
		this.direccion_construccion = direccion_construccion;
	}

	public Boolean getEstado() {
		return estado;
	}

	public void setEstado(Boolean estado) {
		this.estado = estado;
	}

	public Tipo_construccion getId_tipo_construccion() {
		return id_tipo_construccion;
	}

	public void setId_tipo_construccion(Tipo_construccion id_tipo_construccion) {
		this.id_tipo_construccion = id_tipo_construccion;
	}
	

/*
	public Set<Predio> getPredios() {
		return predios;
	}

	public void setPredios(Set<Predio> predios) {
		this.predios = predios;
	}*/

	@Override
	public String toString() {
		return "Construccion [id_construccion=" + id_construccion + ", numero_pisos=" + numero_pisos + ", area_total="
				+ area_total + ", direccion_construccion=" + direccion_construccion + ", estado=" + estado
				+ ", id_tipo_construccion=" + id_tipo_construccion.toString() + "]";
	}
	
	

	

}


