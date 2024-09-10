package org.senechka.lab1.repos;

import org.senechka.lab1.models.Roles;
import org.springframework.data.cassandra.repository.CassandraRepository;

import java.util.Optional;

public interface RolesRepository extends CassandraRepository<Roles, Long> {
    Optional<Roles> findByName(Roles name);
}
