package com.example.demo.Security.Auth;

import com.example.demo.Model.Employee;
import com.example.demo.Model.role;
import com.example.demo.Repository.JPAEmployeeRepository;
import com.example.demo.Security.JwtService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AuthenticationService {

    private final JPAEmployeeRepository repository;

    private final PasswordEncoder passwordEncoder;

    private final JwtService jwtService;

    private final AuthenticationManager authenticationManager;


    public authenticationResponse register(registerRequest requset) {

        var user = Employee.builder()
                .firstName(requset.getFirstName())
                .lastName(requset.getLastName())
                .email(requset.getEmail())
                .password(passwordEncoder.encode(requset.getPassword()))
                .role(role.USER)
                .build();

        repository.save(user);

        var JwtToken = jwtService.generateToken(user);

        return authenticationResponse.builder()
                .token(JwtToken)
                .build();
    }

    public authenticationResponse authenticate(authenticationRequest requset) {
        authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(
                        requset.getEmail(),
                        requset.getPassword()
                )
        );

        var user = repository.findByEmail(requset.getEmail())
                .orElseThrow();
        var JwtToken = jwtService.generateToken(user);

        return authenticationResponse.builder()
                .token(JwtToken)
                .build();
    }
}
