package org.senechka.lab1.models;


import lombok.*;
import org.springframework.data.annotation.Id;

import java.util.Date;
import java.util.UUID;



@Setter
@Getter
@AllArgsConstructor

public class Ticket {

    @Generated
    @Id
    private UUID uuid;

    private UUID userid;

    private UUID ticketid;

    private String fromcity;

    private String tocity;

    private int cost;

    private Date expiredate;

}
