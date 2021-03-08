package com.zanol.scheduling.security.rest;

import com.zanol.scheduling.security.authentication.Authenticator;
import com.zanol.scheduling.security.authentication.model.Credentials;

import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.ws.rs.container.ContainerRequestContext;
import javax.ws.rs.container.ContainerRequestFilter;
import javax.ws.rs.container.PreMatching;
import javax.ws.rs.core.HttpHeaders;
import javax.ws.rs.core.Response;
import javax.ws.rs.ext.Provider;
import java.io.IOException;

@Provider
@PreMatching
public class RequestFilter implements ContainerRequestFilter {

    @Inject
    EntityManager em;

    @Override
    public void filter(ContainerRequestContext requestContext) throws IOException {
        Authenticator authenticator = Authenticator.getInstance();

        String tokenTeste = authenticator.genarateToken(new Credentials("willian.zanol", "asSd23a1s52!@"));
        System.out.println(tokenTeste);
        String token = requestContext.getHeaderString(HttpHeaders.AUTHORIZATION);

        if (!authenticator.isTokenValid(token)) {
            requestContext.abortWith(Response.status(Response.Status.UNAUTHORIZED).build());
            return;
        }

        requestContext.setSecurityContext(authenticator.createSecurityContext(token));
    }
}