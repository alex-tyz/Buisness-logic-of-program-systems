package com.postgres.databases.DTO;

import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Column;

import java.util.Date;
import java.util.UUID;



@AllArgsConstructor
@Data
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
