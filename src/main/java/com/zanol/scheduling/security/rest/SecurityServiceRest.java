package com.zanol.scheduling.security.rest;

import com.zanol.scheduling.security.model.User;
import org.json.JSONObject;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.SecurityContext;

@Path("/user")
@ApplicationScoped
public class SecurityServiceRest {

    @Context
    SecurityContext securityContext;

    @Inject
    EntityManager em;

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Path("{id}")
    public Response getUser(@PathParam("id") Long id) {
        User user = em.find(User.class, id);
//        User userRequest = em.createQuery("SELECT u FROM User u where u.code = '" +  securityContext.getUserPrincipal().getName() + "'", User.class).getSingleResult();
        if (user != null) {
            return Response.ok().entity(user).build();
        } else {
            JSONObject error = new JSONObject();
            error.put("error", "User not found!");

            return Response.ok().entity(error.toString()).status(404).build();
        }
    }
}