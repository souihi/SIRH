package org.repository;

import io.quarkus.hibernate.orm.panache.PanacheRepository;
import jakarta.enterprise.context.ApplicationScoped;
import org.entity.Absence;

@ApplicationScoped
public class AbsenceRepository implements PanacheRepository<Absence> {
}
