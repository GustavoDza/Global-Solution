package br.com.globalsolution.micro.postoeletrico.model;

import java.time.LocalDate;
import java.util.UUID;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import org.hibernate.annotations.GenericGenerator;



@Entity
public class Regional {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)

	private Long idRegional;

	private UUID idOperacao = UUID.randomUUID();
	
	private LocalDate dataOperacao = LocalDate.now();

	public Regional() {}

	public Long getIdRegional() {
		return idRegional;
	}

	public void setIdRegional(Long idRegional) {
		this.idRegional = idRegional;
	}

	public UUID getIdOperacao() {
		return idOperacao;
	}

	public void setIdOperacao(UUID idOperacao) {
		this.idOperacao = idOperacao;
	}

	public LocalDate getDataOperacao() {
		return dataOperacao;
	}

	public void setDataOperacao(LocalDate dataOperacao) {
		this.dataOperacao = dataOperacao;
	}
}
