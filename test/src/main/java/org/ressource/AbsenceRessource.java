package org.ressource;

import jakarta.inject.Inject;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import org.entity.Absence;
import org.service.AbsenceService;

import java.util.List;

@Path("/api/absence")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class AbsenceRessource {

    @Inject
    AbsenceService absenceService;

    @GET
    public List<Absence> getAbsence(){
        return absenceService.absenceList();
    }

    @GET
    @Path("{id}")
    public Absence getAbsenceById(long id){
        return absenceService.absenceById(id);
    }

    @POST
    public Response postAbsence(Absence absence){
        absenceService.createAbsence(absence);
        return Response.ok(absence).build();
    }

    @PUT
    @Path("{id}")
    public Response putAbsence(long id, Absence absence){
        absenceService.updateAbsence(id, absence);
        return Response.ok(absence).build();
    }

    @DELETE
    @Path("{id}")
    public Response deleteAbsence(long id){
        absenceService.deleteAbsence(id);
        return Response.ok().build();
    }
}
