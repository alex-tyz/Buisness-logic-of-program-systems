package org.senechka.lab1.repos;

import org.senechka.lab1.models.City;
import org.springframework.data.cassandra.repository.CassandraRepository;
import org.springframework.data.cassandra.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;

@Repository
public interface CityRepository extends CassandraRepository<City, UUID> {
    @Query("SELECT * FROM city WHERE name = :name ALLOW FILTERING")
    City findByName(@Param("name") String name);

    @Query("SELECT * FROM city WHERE rating > :min AND rating < :max ALLOW FILTERING")
    List<City> findByRating(@Param("min") float min, @Param("max") float max);
}