package org.repository;

import io.quarkus.hibernate.orm.panache.PanacheRepository;
import jakarta.enterprise.context.ApplicationScoped;
import org.entity.Utilisateur;

import java.util.Optional;

@ApplicationScoped
public class UtilisateurRepository implements PanacheRepository<Utilisateur> {

}
