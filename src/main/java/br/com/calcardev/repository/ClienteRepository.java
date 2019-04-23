package br.com.calcardev.repository;

import org.springframework.data.repository.CrudRepository;

import br.com.calcardev.domain.Cliente;

public interface ClienteRepository extends CrudRepository<Cliente, Long> {
	
	Cliente getById(Long id);

}
