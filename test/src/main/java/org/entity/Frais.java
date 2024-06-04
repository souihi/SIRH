package org.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import org.eclipse.microprofile.openapi.annotations.media.Schema;

import java.time.LocalDate;
import java.util.Date;

@Entity
public class Frais {
    @Id
    @GeneratedValue
    private Long id;

    @Column(nullable = false)
    @Schema(example = "Essence")
    private String type;
    @Column(nullable = false)
    @Schema(example = "1€")
    private Double montant;
    @Column(nullable = false)
    private LocalDate date_frais;

    @Column(nullable = false)
    @Schema(example = "6046646649")
    private String justificatif;
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

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public Double getMontant() {
        return montant;
    }

    public void setMontant(Double montant) {
        this.montant = montant;
    }

    public LocalDate getDate_frais() {
        return date_frais;
    }

    public void setDate_frais(LocalDate date_frais) {
        this.date_frais = date_frais;
    }

    public String getJustificatif() {
        return justificatif;
    }

    public void setJustificatif(String justificatif) {
        this.justificatif = justificatif;
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
