package com.thunderscore.api;

import com.thunderscore.entity.Model;
import com.thunderscore.persistence.GenericDao;
import com.thunderscore.util.DaoFactory;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.List;

/**
 * The type Model api.
 */
@Path("/model")
public class ModelAPI {

    /**
     * Gets all.
     *
     * @return all
     */
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<Model> getAll() {
        GenericDao dao = DaoFactory.createDao(Model.class);
        return (List<Model>) dao.getAll();
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
    public Model getById(@PathParam("id") Integer id) {
        GenericDao dao = DaoFactory.createDao(Model.class);
        return (Model) dao.getById(id);
    }

    /**
     * Create response.
     *
     * @param model the model
     * @return the response
     */
    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.TEXT_PLAIN)
    public Response create(Model model) {
        try {
            GenericDao dao = DaoFactory.createDao(Model.class);
            Integer id = dao.insert(model);
            return Response.status(201).entity(id).build();
        } catch (Exception e) {
            return Response.status(406).entity(e.getMessage()).build();
        }
    }

    /**
     * Update response.
     *
     * @param model the model
     * @return the response
     */
    @PATCH
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.TEXT_PLAIN)
    public Response update(Model model) {
        GenericDao dao = DaoFactory.createDao(Model.class);
        try {
            dao.saveOrUpdate(model);
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
        GenericDao dao = DaoFactory.createDao(Model.class);
        try {
            dao.delete(id);
            return Response.status(202).entity("success").build();
        } catch (Exception e) {
            return Response.status(406).entity(e.getMessage()).build();
        }
    }
}
