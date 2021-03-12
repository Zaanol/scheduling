package com.zanol.scheduling.security.authentication.service;

import com.zanol.scheduling.security.authentication.model.Credentials;

import javax.persistence.EntityManager;

public interface AuthenticationService {

    String generateToken(EntityManager em, Credentials credentials);

    Boolean isValidCredentials(EntityManager em, Credentials credentials);
}