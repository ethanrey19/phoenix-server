package me.ethan.sportsbettingapi.models.auth;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.UUID;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Account {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    @Column(name = "username", length = 50, unique = true)
    private String username;

    @Column(name = "email", unique = true)
    private String email;

    @Column(name = "password", length = 75)
    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    private String password;

}
