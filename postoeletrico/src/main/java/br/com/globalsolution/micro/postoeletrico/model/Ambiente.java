package br.com.globalsolution.micro.postoeletrico.model;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;


@Entity
public class Ambiente {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long idAmbiente;
	
	private String cidade;
	
	private String bairro;
	
	private String estado;
	
	private Integer temperatura;
	
	private Integer qualidadeAr;
	
	@ManyToOne(cascade=CascadeType.PERSIST)
	@JoinColumn(name = "id_regional")
	private Regional regional;

	public Ambiente() {}

	public Ambiente(Long idAmbiente, String cidade, String bairro, String estado, Integer temperatura,
			Integer qualidadeAr, Regional regional) {
		this.idAmbiente = idAmbiente;
		this.cidade = cidade;
		this.bairro = bairro;
		this.estado = estado;
		this.temperatura = temperatura;
		this.qualidadeAr = qualidadeAr;
		this.regional = regional;
	}

	public Long getIdAmbiente() {
		return idAmbiente;
	}

	public void setIdAmbiente(Long idAmbiente) {
		this.idAmbiente = idAmbiente;
	}

	public String getCidade() {
		return cidade;
	}

	public void setCidade(String cidade) {
		this.cidade = cidade;
	}

	public String getBairro() {
		return bairro;
	}

	public void setBairro(String bairro) {
		this.bairro = bairro;
	}

	public String getEstado() {
		return estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}

	public Integer getTemperatura() {
		return temperatura;
	}

	public void setTemperatura(Integer temperatura) {
		this.temperatura = temperatura;
	}

	public Integer getQualidadeAr() {
		return qualidadeAr;
	}

	public void setQualidadeAr(Integer qualidadeAr) {
		this.qualidadeAr = qualidadeAr;
	}

	public Regional getRegional() {
		return regional;
	}

	public void setRegional(Regional regional) {
		this.regional = regional;
	}	
}
