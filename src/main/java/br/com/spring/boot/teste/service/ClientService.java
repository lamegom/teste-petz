package br.com.spring.boot.teste.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.spring.boot.teste.domain.Client;
import br.com.spring.boot.teste.repository.ClientRepository;
import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class ClientService {
	
	@Autowired
	private ClientRepository clientRepository;
	
	
	public Client saveClient(Client client) {
		
		
		return clientRepository.save(client);
		

		
	}
	
	public List<Client> getClients(){
		
		return clientRepository.findAll();
	}

	
	public Client getClientById(String id){
		
		Optional<Client> dbClient = clientRepository.findById(id);
		
		Client existingClient = null;

		if(dbClient.isPresent()) {
			existingClient = dbClient.get();

		}

		
		return existingClient;
	}
	
	public void removeClientById(String id) throws Exception {
			
		clientRepository.deleteById(id);

	}
	
	

}
