package com.bootcamp.client.domain;

import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Document(collection = "clients")
public class Client {
    @Id
    private String id;

    @Indexed(unique = true)
    private String documentNumber; // DNI o CE

    private String firstName;
    private String lastName;
    private String email;
    private String phone;
}
