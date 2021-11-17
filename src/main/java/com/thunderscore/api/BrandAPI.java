package com.thunderscore.api;

import com.thunderscore.entity.Brand;
import com.thunderscore.persistence.GenericDao;
import com.thunderscore.util.DaoFactory;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.List;

/**
 * The Brand api.
 */
@Path("/brand")
public class BrandAPI {

    /**
     * Gets all.
     *
     * @return the all
     */
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<Brand> getAll() {
        GenericDao dao = DaoFactory.createDao(Brand.class);
        return (List<Brand>) dao.getAll();
    }

    /**
     * Gets by id.
     *
     * @param id the id
     * @return the by id
     */
    @GET
    @Path("{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Brand getById(@PathParam("id") Integer id) {
        GenericDao dao = DaoFactory.createDao(Brand.class);
        return (Brand) dao.getById(id);
    }

    /**
     * Create response.
     *
     * @param brand the brand
     * @return the response
     */
    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.TEXT_PLAIN)
    public Response create(Brand brand) {
        try {
            GenericDao dao = DaoFactory.createDao(Brand.class);
            Integer id = dao.insert(brand);
            return Response.status(201).entity(id).build();
        } catch (Exception e) {
            return Response.status(406).entity(e.getMessage()).build();
        }
    }

    /**
     * Update response.
     *
     * @param brand the brand
     * @return the response
     */
    @PATCH
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.TEXT_PLAIN)
    public Response update(Brand brand) {
        GenericDao dao = DaoFactory.createDao(Brand.class);
        try {
            dao.saveOrUpdate(brand);
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
        GenericDao dao = DaoFactory.createDao(Brand.class);
        try {
            dao.delete(id);
            return Response.status(202).entity("success").build();
        } catch (Exception e) {
            return Response.status(406).entity(e.getMessage()).build();
        }
    }
}
