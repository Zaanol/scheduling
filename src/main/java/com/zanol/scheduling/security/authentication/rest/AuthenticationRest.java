package com.zanol.scheduling.security.authentication.rest;

import com.zanol.scheduling.security.authentication.exception.AuthenticationException;
import com.zanol.scheduling.security.authentication.model.Credentials;
import com.zanol.scheduling.security.authentication.service.AuthenticationService;
import org.json.JSONObject;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@Path("/auth")
@ApplicationScoped
public class AuthenticationRest {

    @Inject
    EntityManager em;

    @Inject
    AuthenticationService authenticationService;

    @POST
    @Path("/generateToken")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response generateToken(Credentials credentials) {
        try {
            String token = authenticationService.generateToken(em, credentials);

            return Response.ok()
                    .entity(new JSONObject().put("token", token).toString())
                    .build();
        }catch (AuthenticationException e) {
            return Response.ok().status(Response.Status.BAD_REQUEST)
                    .entity(new JSONObject().put("error", e.getMessage()).toString())
                    .build();
        }catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
}