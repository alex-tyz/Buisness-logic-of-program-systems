package com.postgres.databases.repos;


import com.postgres.databases.DTO.Ticket;
import org.springframework.data.jdbc.repository.query.Modifying;
import org.springframework.data.jdbc.repository.query.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.Date;
import java.util.List;
import java.util.UUID;


public interface ActualRepository extends CrudRepository<Ticket,UUID> {

    @Query("INSERT INTO actual VALUES ( gen_random_uuid(), :userid, :ticketid, :fromcity, :tocity, :cost, :expiredate)")
    @Modifying
    void setTicket(@Param("userid") UUID userid, @Param("ticketid") UUID ticketid,
                   @Param("fromcity") String fromcity, @Param("tocity") String tocity, @Param("cost") int cost,
                   @Param("expiredate") Date exipredate);


    @Query("select uuid, userid, ticketid, fromcity, tocity, cost, expiredate from actual where expiredate <= current_timestamp")
    List<Ticket> getExpiredActuals();


    @Query("delete from actual where uuid = :uuid")
    @Modifying
    void deleteActualByUuid(UUID uuid);

}
