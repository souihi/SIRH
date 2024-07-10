package org.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;

@Entity
public class Fichier {
    @Id
    @GeneratedValue
    private Long id;

    private Long idUtilisateur;
    private String path;
    private String filename;


//    #GETTER&SETTER
    public void setId(Long id) {
        this.id = id;
    }
    public Long getId() {
        return id;
    }

    public Long getIdUtilisateur() {
        return idUtilisateur;
    }

    public void setIdUtilisateur(Long idUtilisateur) {
        this.idUtilisateur = idUtilisateur;
    }

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }

    public String getFilename() {
        return filename;
    }

    public void setFilename(String filename) {
        this.filename = filename;
    }
}
