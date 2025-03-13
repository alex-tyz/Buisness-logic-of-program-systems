package org.senechka.lab1.repos;

import org.senechka.lab1.models.User;
import org.springframework.data.cassandra.repository.CassandraRepository;
import org.springframework.data.cassandra.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Optional;
import java.util.UUID;

@Repository
public interface AdminRepository extends CassandraRepository<User, UUID> {

    @Query("SELECT * FROM user WHERE username = :username ALLOW FILTERING")
    Optional<User> getUserByUsername(@Param("username") String username);

    @Query("UPDATE user SET role = 'ROLE_ADMIN' WHERE id = :id")
    void setAdminById(@Param("id") UUID id);

    @Query("SELECT COUNT(*) FROM user WHERE username = :username ALLOW FILTERING")
    long countByUsername(@Param("username") String username);
}
