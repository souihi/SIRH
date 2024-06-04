package org.ressource;

import jakarta.annotation.security.RolesAllowed;
import jakarta.inject.Inject;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import org.eclipse.microprofile.jwt.JsonWebToken;
import org.entity.Utilisateur;
import org.service.UtilisateurService;

import javax.print.attribute.standard.Media;
import java.awt.*;
import java.util.List;

@Path("/api/user")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class UtilisateurRessource {

    @Inject
    UtilisateurService utilisateurService;

    @GET
    public List<Utilisateur> getUtilisateur(){
        return utilisateurService.utilisateurList();
    }

    @GET
    @Path("{id}")
    public Utilisateur getUtilisateurId(long id){
        return utilisateurService.utilisateurListById(id);
    }

    @POST
    public Response postUtilisateur(Utilisateur utilisateur){
        utilisateurService.creatUtilisateur(utilisateur);
        return Response.ok(utilisateur).build();
    }

    @PUT
    @Path("{id}")
    public Response putUtilisateur(Utilisateur utilisateur, long id){
        utilisateurService.updateUtilisateur(id,utilisateur);
        return Response.ok(utilisateur).build();
    }

    @DELETE
    @Path("{id}")
    public Response deleteUtilisateur(long id){
        utilisateurService.deleteUtilisateur(id);
        return Response.ok().build();
    }

}
