package org.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import org.eclipse.microprofile.openapi.annotations.media.Schema;

import java.time.LocalDate;
import java.util.Date;

@Entity
public class Absence {
    @Id
    @GeneratedValue
    private Long id;

    @Column(nullable = false)
    @Schema(example = "Maladie")
    private String type;
    @Column(nullable = false)
    private LocalDate debut;
     @Column(nullable = false)
    private LocalDate fin;
    @Column(nullable = false)
    @Schema(example = "1")
    private String utilisateur_id;


    //GETTER&SETTER
    public void setId(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public LocalDate getDebut() {
        return debut;
    }

    public void setDebut(LocalDate debut) {
        this.debut = debut;
    }

    public LocalDate getFin() {
        return fin;
    }

    public void setFin(LocalDate fin) {
        this.fin = fin;
    }

    public String getUtilisateur_id() {
        return utilisateur_id;
    }

    public void setUtilisateur_id(String utilisateur_id) {
        this.utilisateur_id = utilisateur_id;
    }
}
