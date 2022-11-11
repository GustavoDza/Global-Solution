package br.com.globalsolution.micro.postoeletrico.model;

public class AmbienteDto {
	private String bairro;
	
	private String cidade;
	
	private Integer temperatura;
	
	private Integer qualidadeDoAr;
	
	private String estado;

	public String getBairro() {
		return bairro;
	}

	public void setBairro(String bairro) {
		this.bairro = bairro;
	}

	public String getCidade() {
		return cidade;
	}

	public void setCidade(String cidade) {
		this.cidade = cidade;
	}

	public String getEstado() {
		return estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}

	public int getTemperatura() {
		return temperatura;
	}

	public void setTemperatura(Integer temperatura) {
		this.temperatura = temperatura;
	}

	public Integer getQualidadeDoAr() {
		return qualidadeDoAr;
	}

	public void setQualidadeDoAr(Integer qualidadeDoAr) {
		this.qualidadeDoAr = qualidadeDoAr;
	}
}
