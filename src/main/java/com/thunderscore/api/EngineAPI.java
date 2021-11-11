package com.thunderscore.api;

import com.thunderscore.entity.Engine;
import com.thunderscore.persistence.GenericDao;
import com.thunderscore.util.DaoFactory;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.List;

@Path("/engine")
public class EngineAPI {

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<Engine> getAll() {
        GenericDao dao = DaoFactory.createDao(Engine.class);
        return (List<Engine>) dao.getAll();
    }

    @GET
    @Path("{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Engine getById(@PathParam("id") Integer id) {
        GenericDao dao = DaoFactory.createDao(Engine.class);
        return (Engine) dao.getById(id);
    }

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
