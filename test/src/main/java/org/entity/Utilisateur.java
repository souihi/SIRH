package org.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import org.eclipse.microprofile.openapi.annotations.media.Schema;
import org.mindrot.jbcrypt.BCrypt;

@Entity
public class Utilisateur {
    @Id
    @GeneratedValue
    private Long id;
    @Column(nullable = false)
    @Schema(example = "MOM'S")
    private String username;
    @Column(nullable = false)
    @Schema(example = "S")
    private String name;
    @Column(nullable = false)
    @Schema(example = "MOMS@gmail.com")
    private String email;

    @Column(nullable = false)
    @Schema(example = "MOM'S")
    private String password;

    @Column(nullable = false)
    @Schema(example = "Admin")
    private String role;

    @Column(nullable = false)
    @Schema(example = "Admin")
    private String service_id;



//   Getter&Setter

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = BCrypt.hashpw(password, BCrypt.gensalt());

    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public String getService_id() {
        return service_id;
    }

    public void setService_id(String service_id) {
        this.service_id = service_id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }
}
