package com.thunderscore.api;

import com.thunderscore.entity.Trim;
import com.thunderscore.persistence.GenericDao;
import com.thunderscore.util.DaoFactory;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.List;

@Path("/trim")
public class TrimAPI {

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<Trim> getAll() {
        GenericDao dao = DaoFactory.createDao(Trim.class);
        return (List<Trim>) dao.getAll();
    }

    @GET
    @Path("{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Trim getById(@PathParam("id") Integer id) {
        GenericDao dao = DaoFactory.createDao(Trim.class);
        return (Trim) dao.getById(id);
    }

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.TEXT_PLAIN)
    public Response create(Trim trim) {
        try {
            GenericDao dao = DaoFactory.createDao(Trim.class);
            Integer id = dao.insert(trim);
            return Response.status(201).entity(id).build();
        } catch (Exception e) {
            return Response.status(406).entity(e.getMessage()).build();
        }
    }

    @PATCH
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.TEXT_PLAIN)
    public Response update(Trim trim) {
        GenericDao dao = DaoFactory.createDao(Trim.class);
        try {
            dao.saveOrUpdate(trim);
            return Response.status(202).entity("success").build();
        } catch (Exception e) {
            return Response.status(406).entity(e.getMessage()).build();
        }
    }

    @DELETE
    @Path("{id}")
    @Produces(MediaType.TEXT_PLAIN)
    public Response delete(@PathParam("id") Integer id) {
        GenericDao dao = DaoFactory.createDao(Trim.class);
        try {
            dao.delete(id);
            return Response.status(202).entity("success").build();
        } catch (Exception e) {
            return Response.status(406).entity(e.getMessage()).build();
        }
    }
}
