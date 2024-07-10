package org.ressource;

import jakarta.inject.Inject;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import org.entity.Fichier;
import org.service.FichierService;

import java.io.InputStream;
import java.util.List;

@Path("/upload")
@Consumes(MediaType.MULTIPART_FORM_DATA)
public class FichierRessource {
    @Inject
    FichierService fichierService;

    @GET
    public List<Fichier> getFichier(){
        return fichierService.fichierList();
    }

    @POST
    public Response postFichier(InputStream inputStream, @QueryParam("filename") String filename, @QueryParam("idUtilisateur") Long idUtilisateur){
        fichierService.uploadFichier(inputStream, filename,idUtilisateur);
        return Response.ok().build();
    }
}
