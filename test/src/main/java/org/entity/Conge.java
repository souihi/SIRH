package org.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import org.eclipse.microprofile.openapi.annotations.media.Schema;

import java.time.LocalDate;
import java.util.Date;

@Entity
public class Conge {
    @Id
    @GeneratedValue
    private Long id;

    @Column(nullable = false)
    private LocalDate date_demande;
    @Column(nullable = false)
    private LocalDate date_debut;
    @Column(nullable = false)
    private LocalDate date_fin;
    @Column(nullable = false)
    @Schema(example = "1")
    private String utilisateur_id;

    @Column(nullable = false)
    @Schema(example = "1")
    private String validateur_id;


    //GETTER&SETTER
    public void setId(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }

    public LocalDate getDate_demande() {
        return date_demande;
    }

    public void setDate_demande(LocalDate date_demande) {
        this.date_demande = date_demande;
    }

    public LocalDate getDate_debut() {
        return date_debut;
    }

    public void setDate_debut(LocalDate date_debut) {
        this.date_debut = date_debut;
    }

    public LocalDate getDate_fin() {
        return date_fin;
    }

    public void setDate_fin(LocalDate date_fin) {
        this.date_fin = date_fin;
    }

    public String getUtilisateur_id() {
        return utilisateur_id;
    }

    public void setUtilisateur_id(String utilisateur_id) {
        this.utilisateur_id = utilisateur_id;
    }

    public String getValidateur_id() {
        return validateur_id;
    }

    public void setValidateur_id(String validateur_id) {
        this.validateur_id = validateur_id;
    }
}
