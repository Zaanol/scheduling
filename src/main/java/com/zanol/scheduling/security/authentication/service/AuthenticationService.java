package com.zanol.scheduling.security.authentication.service;

import com.zanol.scheduling.security.authentication.model.Credentials;

public interface AuthenticationService {

    String generateToken(Credentials credentials);

    Boolean isValidCredentials(Credentials credentials);
}