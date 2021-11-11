package com.thunderscore.api;

import com.thunderscore.entity.Color;
import com.thunderscore.persistence.GenericDao;
import com.thunderscore.util.DaoFactory;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.List;

@Path("/color")
public class ColorAPI {

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<Color> getAll() {
        GenericDao dao = DaoFactory.createDao(Color.class);
        return (List<Color>) dao.getAll();
    }

    @GET
    @Path("{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Color getById(@PathParam("id") Integer id) {
        GenericDao dao = DaoFactory.createDao(Color.class);
        return (Color) dao.getById(id);
    }

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.TEXT_PLAIN)
    public Response create(Color color) {
        try {
            GenericDao dao = DaoFactory.createDao(Color.class);
            Integer id = dao.insert(color);
            return Response.status(201).entity(id).build();
        } catch (Exception e) {
            return Response.status(406).entity(e.getMessage()).build();
        }
    }

    @PATCH
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.TEXT_PLAIN)
    public Response update(Color color) {
        GenericDao dao = DaoFactory.createDao(Color.class);
        try {
            dao.saveOrUpdate(color);
            return Response.status(202).entity("success").build();
        } catch (Exception e) {
            return Response.status(406).entity(e.getMessage()).build();
        }
    }

    @DELETE
    @Path("{id}")
    @Produces(MediaType.TEXT_PLAIN)
    public Response delete(@PathParam("id") Integer id) {
        GenericDao dao = DaoFactory.createDao(Color.class);
        try {
            dao.delete(id);
            return Response.status(202).entity("success").build();
        } catch (Exception e) {
            return Response.status(406).entity(e.getMessage()).build();
        }
    }
}
