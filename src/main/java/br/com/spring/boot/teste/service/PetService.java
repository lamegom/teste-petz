package br.com.spring.boot.teste.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.spring.boot.teste.domain.Pet;
import br.com.spring.boot.teste.repository.PetRepository;
import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class PetService {
	
	@Autowired
	private PetRepository petRepository;
	
	
	public Pet savePet(Pet pet) {
		
		
		return petRepository.save(pet);
		

		
	}
	
	public List<Pet> getPets(){
		
		return petRepository.findAll();
	}

	
	public Pet getPetById(String id){
		
		Optional<Pet> dbPet = petRepository.findById(id);
		
		Pet existingPet = null;

		if(dbPet.isPresent()) {
			existingPet = dbPet.get();

		}

		
		return existingPet;
	}
	
	public void removePetById(String id) throws Exception {
			
		petRepository.deleteById(id);

	}
	
	

}
