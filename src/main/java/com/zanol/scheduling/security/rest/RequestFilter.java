package com.zanol.scheduling.security.rest;

import com.zanol.scheduling.security.authentication.Authenticator;
import com.zanol.scheduling.security.authentication.model.Credentials;

import javax.ws.rs.container.ContainerRequestContext;
import javax.ws.rs.container.ContainerRequestFilter;
import javax.ws.rs.container.PreMatching;
import javax.ws.rs.core.HttpHeaders;
import javax.ws.rs.core.Response;
import javax.ws.rs.ext.Provider;

@Provider
@PreMatching
public class RequestFilter implements ContainerRequestFilter {

    @Override
    public void filter(ContainerRequestContext requestContext) {
        String requestPath = requestContext.getUriInfo().getPath();

        if (requestPath.equalsIgnoreCase("/auth/generateToken")) {
            return;
        }

        String token = requestContext.getHeaderString(HttpHeaders.AUTHORIZATION);
        if (!Authenticator.getInstance().isTokenValid(token)) {
            requestContext.abortWith(Response.status(Response.Status.UNAUTHORIZED).build());
            return;
        }

        requestContext.setSecurityContext(
                Authenticator.getInstance().createSecurityContext(token));
    }
}