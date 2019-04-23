package br.com.calcardev.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import br.com.calcardev.domain.Cliente;
import br.com.calcardev.service.ClienteService;
import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping("/api/cliente")
public class ClienteController {
	
	@Autowired
	private ClienteService clienteService;
	
	@PostMapping("")
	@ApiOperation(value="Cria um novo Cliente e com ID altera os Dados")
	public ResponseEntity<?> addCliente(@RequestBody Cliente cliente) {
		Cliente newCliente = clienteService.saveCliente(cliente);
		return new ResponseEntity<Cliente>(newCliente, HttpStatus.CREATED);
	}
	
	@ApiOperation(value="Retorna todos os Clientes")
    @GetMapping("/all")
    public Iterable<Cliente> getAllClientes(){
        return clienteService.findAll();
    }
    
	@ApiOperation(value="Retorna o Cliente")
    @GetMapping("/{id}")
    public ResponseEntity<?> getById(@PathVariable Long id){
        Cliente cliente = clienteService.findById(id);
        return new ResponseEntity<Cliente>(cliente, HttpStatus.OK);
    }
    
	@ApiOperation(value="Remove o Cliente")
    @DeleteMapping("/{id}")
    @ResponseBody
    public ResponseEntity<String> deleteCliente(@PathVariable Long id) {
    	try {
    		clienteService.deleteCliente(id);
    		return ResponseEntity.status(HttpStatus.OK).body("Cliente excluído com Sucesso!");
    	} catch (Exception e) {
    		return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(e.getMessage());
    	}
    }
	

}
