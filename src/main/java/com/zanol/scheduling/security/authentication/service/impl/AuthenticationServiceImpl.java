package com.zanol.scheduling.security.authentication.service.impl;

import com.zanol.scheduling.security.authentication.model.Credentials;
import com.zanol.scheduling.security.authentication.service.AuthenticationService;
import org.springframework.stereotype.Service;

@Service
public class AuthenticationServiceImpl implements AuthenticationService {

    @Override
    public String generateToken(Credentials credentials) {
        return "asdasdasdasd";
    }

    @Override
    public Boolean isValidCredentials(Credentials credentials) {
        return true;
    }
}