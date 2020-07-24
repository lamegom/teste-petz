package br.com.spring.boot.teste.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import br.com.spring.boot.teste.domain.Pet;

public interface PetRepository extends MongoRepository<Pet, String> {


}
