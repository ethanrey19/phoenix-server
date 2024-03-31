package me.ethan.sportsbettingapi.controllers;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import me.ethan.sportsbettingapi.dto.requests.LoginRequest;
import me.ethan.sportsbettingapi.dto.requests.RegisterRequest;
import me.ethan.sportsbettingapi.dto.responses.JwtResponse;
import me.ethan.sportsbettingapi.models.auth.Account;
import me.ethan.sportsbettingapi.service.AccountService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@CrossOrigin
@RestController
@RequiredArgsConstructor
@RequestMapping("/api/auth")
public class AuthController {

    private final AccountService accountService;

    @PostMapping("/register")
    public ResponseEntity<Account> registerAccount(@Valid @RequestBody RegisterRequest registerRequest){
        Account account = accountService.register(registerRequest);

        return new ResponseEntity<>(account, HttpStatus.OK);
    }

    @PostMapping("/login")
    public ResponseEntity<JwtResponse> loginAccount(@Valid @RequestBody LoginRequest loginRequest){
        JwtResponse jwtResponse = accountService.login(loginRequest);

        return new ResponseEntity<>(jwtResponse, HttpStatus.OK);
    }

}
