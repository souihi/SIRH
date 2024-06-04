package org.repository;

import io.quarkus.hibernate.orm.panache.PanacheRepository;
import jakarta.enterprise.context.ApplicationScoped;
import org.entity.Conge;

@ApplicationScoped
public class CongeRepository implements PanacheRepository<Conge> {
}
