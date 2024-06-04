package org.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import org.eclipse.microprofile.openapi.annotations.media.Schema;

@Entity
public class Services {
    @Id
    @GeneratedValue
    private Long id;
    @Column(nullable = false)
    @Schema(example = "Ressource Humaine")
    private String nom;
    @Column(nullable = false)
    @Schema(example = "1")
    private String responsable_id;



 //GETTER&SETTER
    public void setId(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getResponsable_id() {
        return responsable_id;
    }

    public void setResponsable_id(String responsable_id) {
        this.responsable_id = responsable_id;
    }
}
