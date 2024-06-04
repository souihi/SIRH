package org.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import org.eclipse.microprofile.openapi.annotations.media.Schema;

@Entity
public class Role {

    @Id
    @GeneratedValue
    private Long id;

    @Column(nullable = false)
    @Schema(example = "Admin")
    private String role;



    //GETTER&SETTER
    public void setId(Long id) {
        this.id = id;
    }
    public Long getId() {
        return id;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }
}
