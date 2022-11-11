package br.com.globalsolution.micro.postoeletrico.service;

import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.globalsolution.micro.postoeletrico.model.Ambiente;
import br.com.globalsolution.micro.postoeletrico.model.Carro;
import br.com.globalsolution.micro.postoeletrico.model.CarroDto;
import br.com.globalsolution.micro.postoeletrico.repository.AmbienteRepository;
import br.com.globalsolution.micro.postoeletrico.repository.CarroRepository;

@Service
public class CarroService {
	
	@Autowired
	private CarroRepository repository;
	
	@Autowired
	private AmbienteRepository ambienteRepository;
	
	@Autowired
	private ModelMapper mapper;
	
	public Carro cadastraCarro(CarroDto carroDto) throws Exception {
		Carro carro = mapper.map(carroDto, Carro.class);
		if(validaCarro(carro)) {
			try {
				Ambiente ambiente = ambienteRepository.findById(carroDto.getAmbiente()).get();
				
				carro.setAmbiente(ambiente);

				return repository.save(carro);
			}catch(Exception exception) {
				throw new Exception("Ambiente não existente");
			}
		}
		throw new Exception("Campo(s) da requisição inválido(s)");
	}
	
	public Carro atualizaCarro(CarroDto carroDto, Long id) throws Exception {
		Carro carro = mapper.map(carroDto, Carro.class);
		if(validaCarro(carro)) {
			try {
				Ambiente ambiente = ambienteRepository.findById(carroDto.getAmbiente()).get();
				
				carro.setAmbiente(ambiente);
				
				repository.deleteById(id);

				return repository.save(carro);
			}catch(Exception exception) {
				throw new Exception("Ambiente não existente");
			}
		}
		throw new Exception("Campo(s) da requisição inválido(s)");
	}

	private boolean validaCarro(Carro carro) {
		if(carro.getMarca().length() > 20 || carro.getMarca().length() < 4) {
			return false;
		}else if(carro.getPlaca().length() != 7) {
			return false;
		}else if(carro.getQuilometragem() < 0) {
			return false;
		}else if(carro.getModelo().length() > 20) {
			return false;
		}
		return true;
	}

	public List<Carro> listaCarros() {
		return repository.findAll();
	}

	public void deletaCarro(Long id) {
		repository.deleteById(id);
	}
}
