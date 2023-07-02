package com.example.demo.Security.Auth;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/auth")
@RequiredArgsConstructor
public class AuthController {

    private final AuthenticationService authenticationService;

    @PostMapping("/register")
    public ResponseEntity<authenticationResponse> register(
            @RequestBody registerRequest requset
    ){
        return ResponseEntity.ok(authenticationService.register(requset));
    }

    @PostMapping("/authenticate")
    public ResponseEntity<authenticationResponse> register(
            @RequestBody authenticationRequest requset
    ){
        return ResponseEntity.ok(authenticationService.authenticate(requset));
    }


}
