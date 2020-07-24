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

import br.com.spring.boot.teste.domain.Pet;
import br.com.spring.boot.teste.service.PetService;

@RequestMapping("/api/v1")
@RestController
public class PetController {



		@Autowired
		PetService petService;

		@PostMapping("/pets")
		public ResponseEntity<?> createPet(@RequestBody Pet request) throws IOException {
			try {
				final Pet response = petService.savePet(request);
				final URI location = fromCurrentRequest().path("/{id}").buildAndExpand(response.getId()).toUri();
				return ResponseEntity.created(location).body(response);

			} catch(Exception x) {
				x.printStackTrace();
				return ResponseEntity.status(500).build();
			}
		}
		
		@GetMapping("/pets")
		public ResponseEntity<?> getPets() throws IOException {
			try {
				final List<Pet> response = petService.getPets();

				return ResponseEntity.ok(response);

			} catch(Exception x) {
				x.printStackTrace();
				return ResponseEntity.status(500).build();
			}
		}
		
		@GetMapping("/pets/id/{id}")
		public ResponseEntity<?> getPetsById(@PathVariable("id") String id) throws IOException {
			try {
				final Pet response = petService.getPetById(id);

				return ResponseEntity.ok(response);

			} catch(Exception x) {
				x.printStackTrace();
				return ResponseEntity.status(500).build();
			}
		}
		
		@PostMapping("/pets/{id}")
		public ResponseEntity<?> removePetsById(@PathVariable("id") String id) throws IOException {
			try {
				petService.removePetById(id);

				return ResponseEntity.accepted().build();

			} catch(Exception x) {
				x.printStackTrace();
				return ResponseEntity.status(500).build();
			}
		}

	}

