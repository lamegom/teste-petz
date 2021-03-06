package br.com.spring.boot.teste.controller;

import static org.springframework.web.servlet.support.ServletUriComponentsBuilder.fromCurrentRequest;

import java.io.IOException;
import java.net.URI;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.spring.boot.teste.domain.Client;
import br.com.spring.boot.teste.service.ClientService;

@RequestMapping("/api/v1")
@RestController
public class ClientController {



		@Autowired
		ClientService clientService;

		@PostMapping("/clients")
		public ResponseEntity<?> createClient(@RequestBody Client request) throws IOException {
			try {
				final Client response = clientService.saveClient(request);
				final URI location = fromCurrentRequest().path("/{id}").buildAndExpand(response.getId()).toUri();
				return ResponseEntity.created(location).body(response);

			} catch(Exception x) {
				x.printStackTrace();
				return ResponseEntity.status(500).build();
			}
		}
		
		@GetMapping("/clients")
		public ResponseEntity<?> getClients() throws IOException {
			try {
				final List<Client> response = clientService.getClients();

				return ResponseEntity.ok(response);

			} catch(Exception x) {
				x.printStackTrace();
				return ResponseEntity.status(500).build();
			}
		}
		
		@GetMapping("/clients/id/{id}")
		public ResponseEntity<?> getClientsById(@PathVariable("id") String id) throws IOException {
			try {
				final Client response = clientService.getClientById(id);

				return ResponseEntity.ok(response);

			} catch(Exception x) {
				x.printStackTrace();
				return ResponseEntity.status(500).build();
			}
		}
		
		@PostMapping("/clients/{id}")
		public ResponseEntity<?> removeClientsById(@PathVariable("id") String id) throws IOException {
			try {
				clientService.removeClientById(id);

				return ResponseEntity.accepted().build();

			} catch(Exception x) {
				x.printStackTrace();
				return ResponseEntity.status(500).build();
			}
		}

	}

