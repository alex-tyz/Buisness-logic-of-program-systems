package org.senechka.lab1.repos;

import org.senechka.lab1.models.Transaction;
import org.springframework.data.cassandra.repository.CassandraRepository;
import org.springframework.data.cassandra.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.UUID;

public interface TransanctionRepository extends CassandraRepository<Transaction, String> {
    @Query("SELECT * FROM transaction WHERE id = :id ALLOW FILTERING")
    Transaction getTransaction(@Param("id") UUID id);

    @Query("UPDATE transaction set state = 'Paid' WHERE id = :id")
    void setTransactionStatusToProvided(@Param("id") UUID id);

    @Query("UPDATE transaction set state = 'Failed' WHERE id = :id")
    void setTransactionStatusToFailed(@Param("id") UUID id);

    @Query("UPDATE transaction set link = :link WHERE id = :id")
    void setTransactionLink(@Param("id") UUID id, @Param("link") String link);

    @Query("SELECT * FROM transaction WHERE state = :state ALLOW FILTERING")
    List<Transaction> findTransactionsByState(@Param("state") String state);
}
