package org.service;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.transaction.Transactional;
import jakarta.ws.rs.QueryParam;
import jakarta.ws.rs.core.Response;
import org.entity.Fichier;
import org.repository.FichierRepository;

import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.util.List;

@ApplicationScoped
public class FichierService {

    @Inject
    FichierRepository fichierRepository;

    @Transactional
    public List<Fichier> fichierList(){
        return fichierRepository.listAll();
    }
    @Transactional
    public Response uploadFichier(InputStream inputStream, @QueryParam("filename") String filename, @QueryParam("idUtilisateur") Long idUtilisateur){
        if (filename == null || idUtilisateur == null) {
            return Response.status(Response.Status.BAD_REQUEST).entity("Le nom de fichier et l'ID utilisateur sont requis").build();
        }

        try {
            // Créer le répertoire s'il n'existe pas
            Path directoryPath = Paths.get("MonRepertoire");
            Files.createDirectories(directoryPath);

            // Chemin complet du fichier à enregistrer
            Path filePath = directoryPath.resolve(filename);

            // Sauvegarder le fichier sur le disque
            Files.copy(inputStream, filePath, StandardCopyOption.REPLACE_EXISTING);

            // Stocker les informations du fichier dans la base de données
            Fichier fichierEntity = new Fichier();
            fichierEntity.setIdUtilisateur(idUtilisateur);
            fichierEntity.setFilename(filename);
            fichierEntity.setPath(filePath.toString());
            fichierRepository.persist(fichierEntity);

        } catch (IOException e) {
            e.printStackTrace();
            return Response.status(Response.Status.INTERNAL_SERVER_ERROR).entity("Erreur lors du chargement du fichier").build();
        }

        return Response.ok().build();
    }
}
