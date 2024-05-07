package org.senechka.lab1.repos;

import org.springframework.data.cassandra.repository.CassandraRepository;

import org.springframework.security.core.userdetails.User;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends CassandraRepository<User, Long> {
    User findByUsername(String username);
}
