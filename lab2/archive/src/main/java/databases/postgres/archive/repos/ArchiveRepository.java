package databases.postgres.archive.repos;

import databases.postgres.archive.DTO.Ticket;
import org.springframework.data.jdbc.repository.query.Modifying;
import org.springframework.data.jdbc.repository.query.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.Date;
import java.util.UUID;

public interface ArchiveRepository extends CrudRepository<Ticket, UUID> {

    @Query("INSERT INTO archive VALUES ( gen_random_uuid(), :userid, :ticketid, :fromcity, :tocity, :cost, :expiredate)")
    @Modifying
    void setTicket(@Param("userid") UUID userid, @Param("ticketid") UUID ticketid,
                      @Param("fromcity") String fromCity, @Param("tocity") String toCity, @Param("cost") int cost,
                      @Param("expiredate") Date expireDate);
}
