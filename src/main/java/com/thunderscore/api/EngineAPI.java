package com.thunderscore.api;

import com.thunderscore.entity.Engine;
import com.thunderscore.persistence.GenericDao;
import com.thunderscore.util.DaoFactory;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.List;

/**
 * The type Engine api.
 */
@Path("/engine")
public class EngineAPI {

    /**
     * Gets all.
     *
     * @return all
     */
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<Engine> getAll() {
        GenericDao dao = DaoFactory.createDao(Engine.class);
        return (List<Engine>) dao.getAll();
    }

    /**
     * Gets by id.
     *
     * @param id the id
     * @return by id
     */
    @GET
    @Path("{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Engine getById(@PathParam("id") Integer id) {
        GenericDao dao = DaoFactory.createDao(Engine.class);
        return (Engine) dao.getById(id);
    }

    /**
     * Create response.
     *
     * @param engine the engine
     * @return the response
     */
    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.TEXT_PLAIN)
    public Response create(Engine engine) {
        try {
            GenericDao dao = DaoFactory.createDao(Engine.class);
            Integer id = dao.insert(engine);
            return Response.status(201).entity(id).build();
        } catch (Exception e) {
            return Response.status(406).entity(e.getMessage()).build();
        }
    }

    /**
     * Update response.
     *
     * @param engine the engine
     * @return the response
     */
    @PATCH
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.TEXT_PLAIN)
    public Response update(Engine engine) {
        GenericDao dao = DaoFactory.createDao(Engine.class);
        try {
            dao.saveOrUpdate(engine);
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
        GenericDao dao = DaoFactory.createDao(Engine.class);
        try {
            dao.delete(id);
            return Response.status(202).entity("success").build();
        } catch (Exception e) {
            return Response.status(406).entity(e.getMessage()).build();
        }
    }
}
