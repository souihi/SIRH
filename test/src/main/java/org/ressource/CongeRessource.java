package org.ressource;

import jakarta.inject.Inject;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import org.entity.Conge;
import org.service.CongeService;

import java.util.List;

@Path("/api/conge")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class CongeRessource {
    @Inject
    CongeService congeService;

    @GET
    public List<Conge> getConge(){
        return congeService.congeList();
    }
    @GET
    @Path("{id}")
    public Conge getCongeById(long id){
        return congeService.congeById(id);
    }

    @POST
    public Response postConge(Conge conge){
        congeService.createConge(conge);
        return Response.ok(conge).build();
    }

    @PUT
    @Path("{id}")
    public Response putConge(long id, Conge conge){
        congeService.updateConge(id, conge);
        return Response.ok().build();

    }

    @DELETE
    @Path("{id}")
    public Response deleteConge(long id){
        congeService.deleteConge(id);
        return Response.ok().build();
    }
}
