package com.example.demo.Security.Controller;

import com.example.demo.Security.Auth.AuthenticationService;
import com.example.demo.Security.Auth.authenticationRequest;
import com.example.demo.Security.Auth.authenticationResponse;
import com.example.demo.Security.Auth.registerRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Primary;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1")
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
