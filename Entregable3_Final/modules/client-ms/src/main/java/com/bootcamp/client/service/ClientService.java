package com.bootcamp.client.service;

import com.bootcamp.client.api.ClientResponse;
import com.bootcamp.client.api.CreateClientRequest;
import com.bootcamp.client.api.UpdateClientRequest;
import com.bootcamp.client.domain.Client;
import com.bootcamp.client.exception.NotFoundException;
import com.bootcamp.client.repository.ClientRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.dao.DuplicateKeyException;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
@RequiredArgsConstructor
public class ClientService {

    private final ClientRepository repository;

    public Mono<ClientResponse> create(CreateClientRequest request) {
        Client c = Client.builder()
                .documentNumber(request.getDocumentNumber())
                .firstName(request.getFirstName())
                .lastName(request.getLastName())
                .email(request.getEmail())
                .phone(request.getPhone())
                .build();

        return repository.save(c)
                .onErrorMap(DuplicateKeyException.class, ex -> new DuplicateKeyException("documentNumber ya existe"))
                .map(this::toResponse);
    }

    public Mono<ClientResponse> getById(String id) {
        return repository.findById(id)
                .switchIfEmpty(Mono.error(new NotFoundException("Cliente no encontrado")))
                .map(this::toResponse);
    }

    public Mono<ClientResponse> getByDocument(String documentNumber) {
        return repository.findByDocumentNumber(documentNumber)
                .switchIfEmpty(Mono.error(new NotFoundException("Cliente no encontrado")))
                .map(this::toResponse);
    }

    public Flux<ClientResponse> list(String lastName, String email) {
        if (lastName != null && !lastName.isBlank()) {
            return repository.findByLastNameIgnoreCase(lastName).map(this::toResponse);
        }
        if (email != null && !email.isBlank()) {
            return repository.findByEmailIgnoreCase(email).map(this::toResponse);
        }
        return repository.findAll().map(this::toResponse);
    }

    public Mono<ClientResponse> update(String id, UpdateClientRequest request) {
        return repository.findById(id)
                .switchIfEmpty(Mono.error(new NotFoundException("Cliente no encontrado")))
                .flatMap(c -> {
                    c.setFirstName(request.getFirstName());
                    c.setLastName(request.getLastName());
                    c.setEmail(request.getEmail());
                    c.setPhone(request.getPhone());
                    return repository.save(c);
                })
                .map(this::toResponse);
    }

    public Mono<Void> delete(String id) {
        return repository.findById(id)
                .switchIfEmpty(Mono.error(new NotFoundException("Cliente no encontrado")))
                .flatMap(repository::delete);
    }

    private ClientResponse toResponse(Client c) {
        return ClientResponse.builder()
                .id(c.getId())
                .documentNumber(c.getDocumentNumber())
                .firstName(c.getFirstName())
                .lastName(c.getLastName())
                .email(c.getEmail())
                .phone(c.getPhone())
                .build();
    }
}
