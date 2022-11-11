package br.com.globalsolution.micro.postoeletrico.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.globalsolution.micro.postoeletrico.model.Carro;

@Repository
public interface CarroRepository extends JpaRepository<Carro, Long>{

}
