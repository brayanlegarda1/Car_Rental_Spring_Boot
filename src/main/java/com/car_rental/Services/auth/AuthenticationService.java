package com.car_rental.Services.auth;

import com.car_rental.util.JwtService;
import com.car_rental.dto.AuthenticationResponseDto;
import com.car_rental.enums.Role;
import com.car_rental.model.User;
import com.car_rental.repository.UserRepository;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.security.authentication.AuthenticationManager;

@Service
public class AuthenticationService {

    private final UserRepository repository;
    private final PasswordEncoder passwordEncoder;
    private final JwtService jwtService;
    private final AuthenticationManager authenticationManager;


    public AuthenticationService(UserRepository repository, PasswordEncoder passwordEncoder, JwtService jwtService, AuthenticationManager authenticationManager, AuthenticationManager authenticationManager1) {
        this.repository = repository;
        this.passwordEncoder = passwordEncoder;
        this.jwtService = jwtService;
        this.authenticationManager = authenticationManager1;
    }



    public AuthenticationResponseDto register(User request) {
        User user = new User();
        user.setUsername(request.getUsername());
        user.setEmail(request.getEmail());
        user.setPassword(passwordEncoder.encode(request.getPassword()));


        user.setRole(Role.ADMIN);

        user = repository.save(user);

        String token = jwtService.generateToken(user);

        return new AuthenticationResponseDto(token);

    }

    public AuthenticationResponseDto authenticate(User request) {
       authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(
                       request.getUsername(),
                        request.getPassword()
                )
        );

        User user = repository.findByUsername(request.getUsername()).orElseThrow();
        String token = jwtService.generateToken(user);

        return new AuthenticationResponseDto(token);


    }
}
