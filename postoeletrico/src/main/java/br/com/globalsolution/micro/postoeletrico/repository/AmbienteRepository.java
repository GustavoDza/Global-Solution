package br.com.globalsolution.micro.postoeletrico.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.globalsolution.micro.postoeletrico.model.Ambiente;

@Repository
public interface AmbienteRepository extends JpaRepository<Ambiente, Long>{}