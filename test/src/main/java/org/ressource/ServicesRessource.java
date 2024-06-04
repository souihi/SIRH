package org.ressource;

import jakarta.inject.Inject;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import org.entity.Services;
import org.service.ServicesService;

import java.util.List;

@Path("/api/service")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class ServicesRessource {

    @Inject
    ServicesService servicesService;

    @GET
    public List<Services> getService(){
        return servicesService.serviceList();
    }

    @GET
    @Path("{id}")
    public Services getServiceById(long id){
        return servicesService.serviceById(id);
    }

    @POST
    public Response postService(Services services){
        servicesService.createService(services);
        return Response.ok(services).build();
    }
    @PUT
    @Path("{id}")
    public Response putService(long id , Services services){
        servicesService.updateService(id, services);
        return Response.ok(services).build();
    }
    @DELETE
    @Path("{id}")
    public Response deleteService(long id){
        servicesService.deleteService(id);
        return Response.ok().build();
    }
}
