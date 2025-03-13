package org.senechka.lab1.repos;

import org.senechka.lab1.models.Dates;
import org.senechka.lab1.models.Transaction;
import org.senechka.lab1.models.UserTickets;
import org.springframework.data.cassandra.core.mapping.Table;
import org.springframework.data.cassandra.repository.CassandraRepository;
import org.springframework.data.cassandra.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.UUID;


public interface UserticktesRepository extends CassandraRepository<UserTickets, String> {
    @Query("INSERT INTO usertickets (id, name, surname, ticketid, mail) VALUES (uuid(), :name, :surname, :ticketid, :mail)")
    void setTransaction(@Param("name") String name, @Param("surname") String surname, @Param("ticketid") String ticketid,  @Param("mail") String mail);

    @Query("SELECT * FROM usertickets WHERE userid = :id ALLOW FILTERING")
    List<UserTickets> getTransactionByUser(@Param("id") String id);

    @Query("SELECT * FROM usertickets WHERE ticketid = :id ALLOW FILTERING")
    UserTickets getTransactionById(@Param("id") String id);

    @Query("INSERT INTO transaction (id, state, link) VALUES (:id, :state, :link)")
    void addTransaction(@Param("id") UUID id, @Param("state") String state, @Param("link") String link);

    @Query("SELECT * FROM usertickets")
    List<UserTickets> getAllTickets();

    @Query("DELETE FROM usertickets WHERE ticketid = :ticketid")
    void deleteTicketById(@Param("ticketid") String ticketid);
}
