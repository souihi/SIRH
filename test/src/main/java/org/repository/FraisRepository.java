package org.repository;

import io.quarkus.hibernate.orm.panache.PanacheRepository;
import jakarta.enterprise.context.ApplicationScoped;
import org.entity.Frais;

@ApplicationScoped
public class FraisRepository  implements PanacheRepository<Frais> {
}
