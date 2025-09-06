package com.bootcamp.client.api;

import jakarta.validation.constraints.*;
import lombok.Data;

@Data
public class CreateClientRequest {

    @NotBlank
    @Pattern(regexp = "^[0-9]{8,12}$", message = "documentNumber debe tener 8-12 dígitos")
    private String documentNumber;

    @NotBlank
    private String firstName;

    @NotBlank
    private String lastName;

    @Email
    private String email;

    @Pattern(regexp = "^[0-9+\-()\s]{6,20}$", message = "phone inválido")
    private String phone;
}
