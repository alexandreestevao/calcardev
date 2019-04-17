package br.com.calcardev.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import br.com.calcardev.domain.Cliente;

@Repository
public interface ClienteRepository extends CrudRepository<Cliente, Long> {
	
	Cliente getById(Long id);	

}
