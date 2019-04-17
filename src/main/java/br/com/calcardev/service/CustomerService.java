package br.com.calcardev.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.calcardev.domain.Customer;
import br.com.calcardev.repository.CustomerRepository;

@Service
public class CustomerService {
	
	@Autowired
	private CustomerRepository customerRepository;
	
	public Customer saveOrUpdateCustomer(Customer customer) {
		return customerRepository.save(customer);
	}
	
    public Iterable<Customer> findAll(){
        return customerRepository.findAll();
    }
    
    public Customer findById(Long id){
        return customerRepository.getById(id);
    }

    public void delete(Long id){
        Customer customer = findById(id);
        customerRepository.delete(customer);
    }    

}
