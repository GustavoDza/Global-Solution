package br.com.globalsolution.micro.postoeletrico.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import br.com.globalsolution.micro.postoeletrico.model.Carro;
import br.com.globalsolution.micro.postoeletrico.service.CarroService;
import br.com.globalsolution.micro.postoeletrico.model.CarroDto;

@RestController
@RequestMapping("/carros")
public class CarroController {
	
	@Autowired
	private CarroService carroService;
	
	@PostMapping
	@PreAuthorize("hasRole('admin')")
	public ResponseEntity<?> cadastraCarro(@RequestBody CarroDto carroDto) {
		try {
			Carro carroCadastrado = carroService.cadastraCarro(carroDto);
			
			return new ResponseEntity<Carro>(carroCadastrado, HttpStatus.CREATED);
		} catch(Exception e) {
			return ResponseEntity
					.status(HttpStatus.BAD_REQUEST)
					.body(e.getMessage());
		}
	}
	
	@GetMapping
	@PreAuthorize("hasRole('admin')")
	public ResponseEntity<List<Carro>> listaCarro() {		
		return new ResponseEntity<List<Carro>>(carroService.listaCarros(), HttpStatus.OK);
	}
	
	@DeleteMapping("/{id}")
	@PreAuthorize("hasRole('admin')")
	public ResponseEntity<?> deletaCarro(@PathVariable(value = "id") Long id) {
		carroService.deletaCarro(id);

		return new ResponseEntity<>(HttpStatus.OK);
	}
	
	@PutMapping("/{id}")
	@PreAuthorize("hasRole('admin')")
	public ResponseEntity<?> atualizaCarro(@PathVariable(value = "id") Long id, @RequestBody CarroDto carroDto){
		try {
			Carro carroAtualizado = carroService.atualizaCarro(carroDto, id);
			return new ResponseEntity<Carro>(carroAtualizado, HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		}
	}
}
