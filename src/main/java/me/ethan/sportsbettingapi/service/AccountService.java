package me.ethan.sportsbettingapi.service;

import lombok.RequiredArgsConstructor;
import me.ethan.sportsbettingapi.dto.requests.LoginRequest;
import me.ethan.sportsbettingapi.dto.requests.RegisterRequest;
import me.ethan.sportsbettingapi.dto.responses.JwtResponse;
import me.ethan.sportsbettingapi.models.auth.Account;
import me.ethan.sportsbettingapi.repository.AccountRepository;
import me.ethan.sportsbettingapi.security.jwt.JwtUtils;
import org.springframework.security.core.Authentication;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AccountService {

    @Autowired
    AccountRepository accountRepository;

    @Autowired
    PasswordEncoder passwordEncoder;

    @Autowired
    AuthenticationManager authenticationManager;

    @Autowired
    JwtUtils jwtUtils;

    public Account register(RegisterRequest registerRequest) {
        Account account = new Account(null, registerRequest.getUsername(), registerRequest.getEmail(),
                passwordEncoder.encode(registerRequest.getPassword()));
        return accountRepository.save(account);
    }

    public JwtResponse login(LoginRequest loginRequest) {
        Authentication authentication = authenticationManager
                .authenticate(new UsernamePasswordAuthenticationToken(loginRequest.getUsername(), loginRequest.getPassword()));

        SecurityContextHolder.getContext().setAuthentication(authentication);
        String jwt = jwtUtils.generateJwtToken(authentication);

        return new JwtResponse(jwt, loginRequest.getUsername());
    }
}
