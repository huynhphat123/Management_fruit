package com.fruit.Htp.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.FieldDefaults;

@Data
@Entity

@FieldDefaults (level = AccessLevel.PRIVATE)
public class User {
    @Id
   @GeneratedValue(strategy = GenerationType.AUTO)
    Long id;
    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    String password;
    String email;
    String fullName;

}
