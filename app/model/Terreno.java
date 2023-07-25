package model;

import javax.persistence.*;

@Entity
public class Terreno {
	
	
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id_terreno;
	
	private Double area;

	private Double valor_comercial;
	
	private Boolean cerca_fuentes_agua;

	private Boolean tiene_construcciones;
	
	private Boolean estado;
	
	@OneToOne
	@JoinColumn(name="id_tipo_terreno")
	private Tipo_terreno tipo_terreno;

	public Integer getId_terreno() {
		return id_terreno;
	}

	public void setId_terreno(Integer id_terreno) {
		this.id_terreno = id_terreno;
	}

	public Double getArea() {
		return area;
	}

	public void setArea(Double area) {
		this.area = area;
	}

	public Double getValor_comercial() {
		return valor_comercial;
	}

	public void setValor_comercial(Double valor_comercial) {
		this.valor_comercial = valor_comercial;
	}

	public Boolean getCerca_fuentes_agua() {
		return cerca_fuentes_agua;
	}

	public void setCerca_fuentes_agua(Boolean cerca_fuentes_agua) {
		this.cerca_fuentes_agua = cerca_fuentes_agua;
	}

	public Boolean getTiene_construcciones() {
		return tiene_construcciones;
	}

	public void setTiene_construcciones(Boolean tiene_construcciones) {
		this.tiene_construcciones = tiene_construcciones;
	}

	public Boolean getEstado() {
		return estado;
	}

	public void setEstado(Boolean estado) {
		this.estado = estado;
	}

	public Tipo_terreno getTipo_terreno() {
		return tipo_terreno;
	}

	public void setTipo_terreno(Tipo_terreno tipo_terreno) {
		this.tipo_terreno = tipo_terreno;
	}
	

	
	
	
}
