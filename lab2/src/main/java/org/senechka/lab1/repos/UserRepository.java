package org.senechka.lab1.repos;

import org.senechka.lab1.models.Roles;
import org.senechka.lab1.models.User;
import org.springframework.data.cassandra.repository.CassandraRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface UserRepository extends CassandraRepository<User, Long> {

    Optional<User> findByEmail(String email);

    Optional<User> findById(Long id);

    Boolean existsByEmail(String email);

    List<User> findAllByRolesName(Roles role);

}
