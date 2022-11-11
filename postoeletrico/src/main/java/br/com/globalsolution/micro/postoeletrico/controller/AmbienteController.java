package br.com.globalsolution.micro.postoeletrico.controller;

import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.globalsolution.micro.postoeletrico.model.Ambiente;
import br.com.globalsolution.micro.postoeletrico.model.AmbienteDto;
import br.com.globalsolution.micro.postoeletrico.model.Regional;
import br.com.globalsolution.micro.postoeletrico.repository.AmbienteRepository;

@RestController
@RequestMapping("/ambientes")
public class AmbienteController {
	
	@Autowired
	private ModelMapper mapper;
	
	@Autowired
	private AmbienteRepository repository;
	
	@GetMapping
	@PreAuthorize("hasRole('admin')")
	public ResponseEntity<List<Ambiente>> listagemAmbientes() {		
		return new ResponseEntity<List<Ambiente>>(repository.findAll(), HttpStatus.OK);
	}
	
	@PostMapping
	@PreAuthorize("hasRole('admin')")
	public ResponseEntity<?> cadastroAmbientes(@RequestBody AmbienteDto dto) {
		Ambiente ambiente = mapper.map(dto, Ambiente.class);
		
		ambiente.setRegional(new Regional());

		repository.save(ambiente);

		return new ResponseEntity<Ambiente>(ambiente, HttpStatus.CREATED);
	}
}
