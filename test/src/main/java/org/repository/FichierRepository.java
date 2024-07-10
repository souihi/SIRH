package org.repository;

import io.quarkus.hibernate.orm.panache.PanacheRepository;
import jakarta.enterprise.context.ApplicationScoped;
import org.entity.Fichier;

@ApplicationScoped
public class FichierRepository implements PanacheRepository<Fichier> {
}
