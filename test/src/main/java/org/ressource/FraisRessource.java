package org.ressource;

import jakarta.inject.Inject;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import org.entity.Frais;
import org.service.FraisService;

import java.util.List;

@Path("/api/frais")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class FraisRessource {

    @Inject
    FraisService fraisService;

    @GET
    public List<Frais> getFrais(){
        return fraisService.fraisList();
    }
    @GET
    @Path("{id}")
    public Frais getFraisById(long id){
        return fraisService.fraisById(id);
    }

    @POST
    public Response postFrais(Frais frais){
        fraisService.createFrais(frais);
        return Response.ok(frais).build();
    }
    @PUT
    @Path("{id}")
    public Response putFrais(long id, Frais frais){
        fraisService.udpateFrais(id, frais);
        return Response.ok(frais).build();
    }

    @DELETE
    @Path("{id}")
    public Response deleteFrais(long id){
        fraisService.deleteFrais(id);
        return Response.ok().build();
    }
}
