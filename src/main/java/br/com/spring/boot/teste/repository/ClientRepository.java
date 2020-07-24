package br.com.spring.boot.teste.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import br.com.spring.boot.teste.domain.Client;

public interface ClientRepository extends MongoRepository<Client, String> {


}
