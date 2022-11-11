package br.com.globalsolution.micro.postoeletrico.model;

public class CarroDto {

	private String modelo;
	
	private String marca;

	private String placa;

	private Integer quilometragem;
	
	private Long ambiente;
	

	public String getMarca() {
		return marca;
	}

	public void setMarca(String marca) {
		this.marca = marca;
	}
	
	public Long getAmbiente() {
		return ambiente;
	}

	public void setAmbiente(Long ambiente) {
		this.ambiente = ambiente;
	}

	public String getModelo() {
		return modelo;
	}

	public void setModelo(String modelo) {
		this.modelo = modelo;
	}

	public String getPlaca() {
		return placa;
	}

	public void setPlaca(String placa) {
		this.placa = placa;
	}

	public double getQuilometragem() {
		return quilometragem;
	}

	public void setQuilometragem(int quilometragem) {
		this.quilometragem = quilometragem;
	}
}
