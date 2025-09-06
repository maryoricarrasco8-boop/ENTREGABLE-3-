package com.bootcamp.client.repository;

import com.bootcamp.client.domain.Client;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface ClientRepository extends ReactiveMongoRepository<Client, String> {
    Mono<Client> findByDocumentNumber(String documentNumber);
    Flux<Client> findByLastNameIgnoreCase(String lastName);
    Flux<Client> findByEmailIgnoreCase(String email);
}
