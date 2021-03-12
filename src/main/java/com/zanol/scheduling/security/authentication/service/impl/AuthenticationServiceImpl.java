package com.zanol.scheduling.security.authentication.service.impl;

import com.zanol.scheduling.persist.PersistEngine;
import com.zanol.scheduling.security.authentication.Authenticator;
import com.zanol.scheduling.security.authentication.exception.AuthenticationException;
import com.zanol.scheduling.security.authentication.model.Credentials;
import com.zanol.scheduling.security.authentication.service.AuthenticationService;
import com.zanol.scheduling.security.model.User;

import javax.enterprise.context.ApplicationScoped;
import javax.persistence.EntityManager;

@ApplicationScoped
public class AuthenticationServiceImpl implements AuthenticationService {

    @Override
    public String generateToken(EntityManager em, Credentials credentials) {
        if (!credentials.isFilled()) {
            throw new AuthenticationException("Usuário e senha devem ser preenchidos!");
        }

        if (isValidCredentials(em, credentials)) {
            return Authenticator.getInstance().genarateToken(credentials);
        }else {
            throw new AuthenticationException("Usuário e/ou senha inválido(s)!");
        }
    }

    @Override
    public Boolean isValidCredentials(EntityManager em, Credentials credentials) {
        User user = (User) PersistEngine.getObject(
                em, User.class, "code", credentials.getUserCode());

        if (user == null)
            return false;

        return user.isValidPassword(credentials.getUserPassword());
    }
}