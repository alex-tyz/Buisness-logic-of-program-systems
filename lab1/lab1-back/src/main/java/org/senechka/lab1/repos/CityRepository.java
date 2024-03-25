package org.senechka.lab1.repos;

import org.senechka.lab1.models.City;
import org.springframework.data.cassandra.repository.CassandraRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface CityRepository extends CassandraRepository<City, UUID> {
    // Здесь могут быть дополнительные методы для работы с городами в базе данных
}