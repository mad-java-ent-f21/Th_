package com.thunderscore.api;

import com.thunderscore.entity.Transmission;
import com.thunderscore.persistence.GenericDao;
import com.thunderscore.util.DaoFactory;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.List;

/**
 * The type Transmission api.
 */
@Path("/transmission")
public class TransmissionAPI {

    /**
     * Gets all.
     *
     * @return all
     */
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<Transmission> getAll() {
        GenericDao dao = DaoFactory.createDao(Transmission.class);
        return (List<Transmission>) dao.getAll();
    }

    /**
     * Gets by id.
     *
     * @param id the id
     * @return the id
     */
    @GET
    @Path("{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Transmission getById(@PathParam("id") Integer id) {
        GenericDao dao = DaoFactory.createDao(Transmission.class);
        return (Transmission) dao.getById(id);
    }

    /**
     * Create response.
     *
     * @param transmission the transmission
     * @return the response
     */
    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.TEXT_PLAIN)
    public Response create(Transmission transmission) {
        try {
            GenericDao dao = DaoFactory.createDao(Transmission.class);
            Integer id = dao.insert(transmission);
            return Response.status(201).entity(id).build();
        } catch (Exception e) {
            return Response.status(406).entity(e.getMessage()).build();
        }
    }

    /**
     * Update response.
     *
     * @param transmission the transmission
     * @return the response
     */
    @PATCH
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.TEXT_PLAIN)
    public Response update(Transmission transmission) {
        GenericDao dao = DaoFactory.createDao(Transmission.class);
        try {
            dao.saveOrUpdate(transmission);
            return Response.status(202).entity("success").build();
        } catch (Exception e) {
            return Response.status(406).entity(e.getMessage()).build();
        }
    }

    /**
     * Delete response.
     *
     * @param id the id
     * @return the response
     */
    @DELETE
    @Path("{id}")
    @Produces(MediaType.TEXT_PLAIN)
    public Response delete(@PathParam("id") Integer id) {
        GenericDao dao = DaoFactory.createDao(Transmission.class);
        try {
            dao.delete(id);
            return Response.status(202).entity("success").build();
        } catch (Exception e) {
            return Response.status(406).entity(e.getMessage()).build();
        }
    }
}
