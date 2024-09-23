package databases.postgres.archive.DTO;

import lombok.AllArgsConstructor;
import lombok.Generated;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Column;

import java.util.Date;
import java.util.UUID;


@Setter
@Getter
@AllArgsConstructor

public class Ticket {

    @Generated
    @Id
    private UUID uuid;
    @Column
    private UUID userid;
    @Column
    private UUID ticketid;
    @Column
    private String fromcity;
    @Column
    private String tocity;
    @Column
    private int cost;
    @Column
    private Date expiredate;

}
