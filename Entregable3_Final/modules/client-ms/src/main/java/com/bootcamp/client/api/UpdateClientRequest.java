package com.bootcamp.client.api;

import jakarta.validation.constraints.*;
import lombok.Data;

@Data
public class UpdateClientRequest {

    @NotBlank
    private String firstName;

    @NotBlank
    private String lastName;

    @Email
    private String email;

    @Pattern(regexp = "^[0-9+\-()\s]{6,20}$", message = "phone inválido")
    private String phone;
}
