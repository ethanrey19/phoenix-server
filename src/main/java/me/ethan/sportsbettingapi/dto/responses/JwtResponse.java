package me.ethan.sportsbettingapi.dto.responses;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class JwtResponse {

    private String token;

    private String type = "Bearer";

    private String username;

    public JwtResponse(String token, String username) {
        this.token = token;
        this.type = type;
        this.username = username;
    }
}
