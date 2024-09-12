package org.senechka.lab1.repos;

import org.senechka.lab1.models.User;
import org.springframework.data.cassandra.repository.CassandraRepository;
import org.springframework.data.cassandra.repository.Query;

import java.util.UUID;

public interface AdminRepository extends CassandraRepository<User, UUID> {
    @Query("SELECT * FROM user WHERE username=:username ALLOW FILTERING")
    User getUserInformationByUsername(String username);

    @Query("UPDATE user set role = 'ADMIN' WHERE id = :id")
    void setAdminById(UUID id);
}
