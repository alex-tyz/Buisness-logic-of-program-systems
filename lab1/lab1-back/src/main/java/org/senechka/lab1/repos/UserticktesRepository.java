package org.senechka.lab1.repos;

import org.senechka.lab1.models.Dates;
import org.senechka.lab1.models.UserTickets;
import org.springframework.data.cassandra.core.mapping.Table;
import org.springframework.data.cassandra.repository.CassandraRepository;
import org.springframework.data.cassandra.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.UUID;


public interface UserticktesRepository extends CassandraRepository<Dates, String> {
    @Query("INSERT INTO usertickets (id, name, surname, ticketid, userid, vreify) VALUES (uuid(), :name, :surname, :ticketid, :userid, :verify)")
    void setTransaction(@Param("name") String name, @Param("surname") String surname, @Param("ticketid") String ticketid, @Param("userid") String userid, @Param("verify") String verify);

    @Query("SELECT * FROM usertickets WHERE id = :id")
    UserTickets getTransaction(@Param("id") UUID id);

    @Query("SELECT * FROM usertickets WHERE name = :name")
    List<UserTickets> getTransationByUser(@Param("name") String name);

    @Query("INSERT INTO transaction (id, state, link) VALUES (:id, :state, :link)")
    void addTransaction(@Param("id") UUID id, @Param("state") String state, @Param("link") String link);


}
