package com.zanol.scheduling.security.rest;

import com.zanol.scheduling.security.model.User;
import org.jose4j.json.internal.json_simple.JSONObject;

import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@Path("/user")
public class SecurityServiceRest {

    @Inject
    EntityManager em;

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Path("{id}")
    public Response getUser(@PathParam("id") Long id) {
        User user = em.find(User.class, id);

        if (user != null) {
            return Response.ok().entity(user).build();
        } else {
            JSONObject error = new JSONObject();
            error.put("error", "User not found!");

            return Response.ok().entity(error.toString()).status(404).build();
        }
    }
}