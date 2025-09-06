package com.bootcamp.client.api;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class ClientResponse {
    private String id;
    private String documentNumber;
    private String firstName;
    private String lastName;
    private String email;
    private String phone;
}
