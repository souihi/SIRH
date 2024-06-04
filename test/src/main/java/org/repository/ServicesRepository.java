package org.repository;

import io.quarkus.hibernate.orm.panache.PanacheRepository;
import jakarta.enterprise.context.ApplicationScoped;
import org.entity.Services;

@ApplicationScoped
public class ServicesRepository implements PanacheRepository<Services> {
}
