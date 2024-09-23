package org.senechka.lab1.security.repos;

import org.senechka.lab1.models.Roles;
import org.senechka.lab1.models.User;
import org.springframework.data.cassandra.repository.CassandraRepository;
import org.springframework.data.cassandra.repository.Query;

import java.util.List;
import java.util.Optional;
import java.util.UUID;


public interface UserRepository extends CassandraRepository<User, UUID> {

    Optional<User> findByEmail(String email);
    @Query("SELECT * FROM user WHERE username =:username ALLOW FILTERING")
    Optional<User> findByUsername (String username);
    @Query("SELECT * FROM user WHERE id = :id ALLOW FILTERING")
    Optional<User> findById(UUID id);
    @Query("SELECT COUNT (*) FROM user WHERE email = :email ALLOW FILTERING")
    int existsByEmail(String email);
    //List<User> findAllByRole(Roles role);
    @Query("SELECT COUNT (*) FROM user WHERE username = :username ALLOW FILTERING")
    int existsByUsername(String username);

}
