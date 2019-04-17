package br.com.calcardev.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import br.com.calcardev.domain.Customer;
import br.com.calcardev.service.CustomerService;
 

 
@RestController
public class RestWebController {
	
	@Autowired
	private CustomerService customerService;
	
	@RequestMapping(value = "/getallcustomers", method = RequestMethod.GET)
    public Iterable<Customer> getAll(){
        return customerService.findAll();
    }	
  
	@RequestMapping(value="/postcustomer", method=RequestMethod.POST)
	public ResponseEntity<?> postCustomer(@RequestBody Customer customer) {
		Customer cust = customerService.saveOrUpdateCustomer(customer);
		return new ResponseEntity<Customer>(cust, HttpStatus.CREATED);
	}  

	@DeleteMapping(value="/deletecustomer/{id}")
	public ResponseEntity<?> deleteCustomer(@PathVariable Long id){
		customerService.delete(id);
		return new ResponseEntity<String>("Cliente excluído com sucesso.", HttpStatus.OK);
	}
  
}
