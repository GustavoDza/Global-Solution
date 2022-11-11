package br.com.globalsolution.micro.postoeletrico.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class Carro {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	private String marca;
	
	private String placa;

	private Integer quilometragem;

	private String modelo;
	
	@ManyToOne
	@JoinColumn(name = "id_ambiente")
	private Ambiente ambiente;

	public Carro() {
		
	}

	public Carro(String marca, String modelo, String placa, Integer quilometragem, Ambiente ambiente) {
		this.marca = marca;
		this.modelo = modelo;
		this.placa = placa;
		this.quilometragem = quilometragem;
		this.ambiente = ambiente;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getMarca() {
		return marca;
	}

	public void setMarca(String marca) {
		this.marca = marca;
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

	public Integer getQuilometragem() {
		return quilometragem;
	}

	public void setQuilometragem(Integer quilometragem) {
		this.quilometragem = quilometragem;
	}

	public Ambiente getAmbiente() {
		return ambiente;
	}

	public void setAmbiente(Ambiente ambiente) {
		this.ambiente = ambiente;
	}
}
