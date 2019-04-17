package br.com.calcardev.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.calcardev.domain.Cliente;
import br.com.calcardev.repository.ClienteRepository;

@Service
public class ClienteService {
	
	@Autowired
	private ClienteRepository clienteRepository;
	
	public Cliente saveCliente(Cliente cliente) {
		
		// Análise dos dados do Cliente
    	String div = "Divorciado";
    	String compD = cliente.getEstadoCivil();
    	String viu = "Viuva";
    	String compV = cliente.getEstadoCivil();
    	
    	if(div.equals(compD)) {
    		cliente.setLimite("Reprovado pela política de crédito");
    		cliente.setResultadoAnalise("Negado");
    	}else if(viu.equals(compV)) {
    		cliente.setLimite("Reprovado pela política de crédito");
    		cliente.setResultadoAnalise("Negado");
    	} else {
    		
    		if(cliente.getRendaMensal()<500) {
            	cliente.setLimite("Renda baixa");
            	cliente.setResultadoAnalise("Negado");
    		}else {
        		Double margem = cliente.getRendaMensal()/3;
        		
                if(margem>=100 && margem<=499){
                	cliente.setLimite("Entre 100 - 500");
                }else if(margem<=999){
                	cliente.setLimite("Entre 500 - 1.000");
                }else if(margem<=1499){
                	cliente.setLimite("Entre 1.000 - 1.500");
                }else if(margem<=1999) {
                	cliente.setLimite("Entre 1.500 - 2.000");
                }else if(margem>=2000) {
                	cliente.setLimite("Superior a 2.000");
                }   
                cliente.setResultadoAnalise("Aprovado");
    		}

    	}
        
    	if(cliente.getDependentes()==null || cliente.getDependentes()<1) {
    		cliente.setDependentes(0);
    	}  		
		
		return clienteRepository.save(cliente);
	}
	
    public Iterable<Cliente> findAll(){
        return clienteRepository.findAll();
    }
    
    public Cliente findById(Long id){
        return clienteRepository.getById(id);
    }
    
    public void deleteCliente(Long id){
        Cliente cliente = findById(id);
        clienteRepository.delete(cliente);
    }

}
