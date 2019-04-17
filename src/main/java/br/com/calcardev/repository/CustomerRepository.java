package br.com.calcardev.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import br.com.calcardev.domain.Customer;

@Repository
public interface CustomerRepository extends CrudRepository<Customer, Long> {
	
	Customer getById(Long id);

}
