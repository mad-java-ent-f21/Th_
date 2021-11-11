package com.thunderscore.api;

import com.thunderscore.entity.Country;
import com.thunderscore.persistence.GenericDao;
import com.thunderscore.util.DaoFactory;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.List;

@Path("/country")
public class CountryAPI {

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<Country> getAll() {
        GenericDao dao = DaoFactory.createDao(Country.class);
        return (List<Country>) dao.getAll();
    }

    @GET
    @Path("{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Country getById(@PathParam("id") Integer id) {
        GenericDao dao = DaoFactory.createDao(Country.class);
        return (Country) dao.getById(id);
    }

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.TEXT_PLAIN)
    public Response create(Country country) {
        try {
            GenericDao dao = DaoFactory.createDao(Country.class);
            Integer id = dao.insert(country);
            return Response.status(201).entity(id).build();
        } catch (Exception e) {
            return Response.status(406).entity(e.getMessage()).build();
        }
    }

    @PATCH
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.TEXT_PLAIN)
    public Response update(Country country) {
        GenericDao dao = DaoFactory.createDao(Country.class);
        try {
            dao.saveOrUpdate(country);
            return Response.status(202).entity("success").build();
        } catch (Exception e) {
            return Response.status(406).entity(e.getMessage()).build();
        }
    }

    @DELETE
    @Path("{id}")
    @Produces(MediaType.TEXT_PLAIN)
    public Response delete(@PathParam("id") Integer id) {
        GenericDao dao = DaoFactory.createDao(Country.class);
        try {
            dao.delete(id);
            return Response.status(202).entity("success").build();
        } catch (Exception e) {
            return Response.status(406).entity(e.getMessage()).build();
        }
    }
}
