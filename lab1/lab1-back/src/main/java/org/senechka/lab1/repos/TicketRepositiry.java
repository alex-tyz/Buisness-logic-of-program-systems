package org.senechka.lab1.repos;

import org.senechka.lab1.models.City;
import org.senechka.lab1.models.Dates;
import org.springframework.data.cassandra.repository.CassandraRepository;
import org.springframework.data.cassandra.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.UUID;

public interface TicketRepositiry extends CassandraRepository<Dates, String> {
    @Query("SELECT * FROM dates WHERE fromcity = :name ALLOW FILTERING")
    List<Dates> findByName(@Param("name") String name);
}
