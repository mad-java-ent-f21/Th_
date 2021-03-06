package com.thunderscore.api;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Response;

/**
 * The type Car search.
 */
@Path("/carsearch")
public class CarSearch {
    /**
     * Get car response.
     *
     * @return the response
     */
    @GET
    @Produces("text/plain")
    public Response getCar(){
        String output = "car";
        return Response.status(200).entity(output).build();
    }
}
