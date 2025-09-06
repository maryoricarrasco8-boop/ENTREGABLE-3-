package com.bootcamp.client.api;

import com.bootcamp.client.service.ClientService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springdoc.core.annotations.ParameterObject;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/clients")
@RequiredArgsConstructor
public class ClientController {

    private final ClientService service;

    // Crear
    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Mono<ClientResponse> create(@RequestBody @Valid CreateClientRequest request) {
        return service.create(request);
    }

    // Obtener por ID
    @GetMapping("/{id}")
    public Mono<ClientResponse> getById(@PathVariable String id) {
        return service.getById(id);
    }

    // Obtener por documento
    @GetMapping("/document/{documentNumber}")
    public Mono<ClientResponse> getByDocument(@PathVariable String documentNumber) {
        return service.getByDocument(documentNumber);
    }

    // Listar (opcionalmente filtra por lastName o email)
    @GetMapping
    public Flux<ClientResponse> list(@RequestParam(required = false) String lastName,
                                     @RequestParam(required = false) String email) {
        return service.list(lastName, email);
    }

    // Actualizar
    @PutMapping("/{id}")
    public Mono<ClientResponse> update(@PathVariable String id,
                                       @RequestBody @Valid UpdateClientRequest request) {
        return service.update(id, request);
    }

    // Eliminar
    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public Mono<Void> delete(@PathVariable String id) {
        return service.delete(id);
    }
}
