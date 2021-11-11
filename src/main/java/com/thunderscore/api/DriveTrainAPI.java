package com.thunderscore.api;

import com.thunderscore.entity.DriveTrain;
import com.thunderscore.persistence.GenericDao;
import com.thunderscore.util.DaoFactory;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.List;

@Path("/drive-train")
public class DriveTrainAPI {
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<DriveTrain> getAll() {
        GenericDao dao = DaoFactory.createDao(DriveTrain.class);
        return (List<DriveTrain>) dao.getAll();
    }

    @GET
    @Path("{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public DriveTrain getById(@PathParam("id") Integer id) {
        GenericDao dao = DaoFactory.createDao(DriveTrain.class);
        return (DriveTrain) dao.getById(id);
    }

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.TEXT_PLAIN)
    public Response create(DriveTrain driveTrain) {
        try {
            GenericDao dao = DaoFactory.createDao(DriveTrain.class);
            Integer id = dao.insert(driveTrain);
            return Response.status(201).entity(id).build();
        } catch (Exception e) {
            return Response.status(406).entity(e.getMessage()).build();
        }
    }

    @PATCH
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.TEXT_PLAIN)
    public Response update(DriveTrain driveTrain) {
        GenericDao dao = DaoFactory.createDao(DriveTrain.class);
        try {
            dao.saveOrUpdate(driveTrain);
            return Response.status(202).entity("success").build();
        } catch (Exception e) {
            return Response.status(406).entity(e.getMessage()).build();
        }
    }

    @DELETE
    @Path("{id}")
    @Produces(MediaType.TEXT_PLAIN)
    public Response delete(@PathParam("id") Integer id) {
        GenericDao dao = DaoFactory.createDao(DriveTrain.class);
        try {
            dao.delete(id);
            return Response.status(202).entity("success").build();
        } catch (Exception e) {
            return Response.status(406).entity(e.getMessage()).build();
        }
    }
}
