package com.zanol.scheduling.security.authentication.controller;

import com.zanol.scheduling.security.authentication.model.Credentials;
import com.zanol.scheduling.security.authentication.repository.AuthenticationRepository;
import com.zanol.scheduling.security.authentication.service.AuthenticationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/auth")
public class AuthenticationController {

    @Autowired
    AuthenticationRepository authenticationRepository;

    @Autowired
    AuthenticationService authenticationService;

    @PostMapping("/generateToken")
    public ResponseEntity<String> createCompany(@RequestBody Credentials credentials) {
        String token = authenticationService.generateToken(credentials);

        return new ResponseEntity<>(token, HttpStatus.CREATED);
    }
}