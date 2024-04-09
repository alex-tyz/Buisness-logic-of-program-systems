package org.senechka.lab1.models;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.cassandra.core.mapping.Column;
import org.springframework.data.cassandra.core.mapping.PrimaryKey;
import org.springframework.data.cassandra.core.mapping.Table;

import java.util.UUID;

@Getter
@Setter
@AllArgsConstructor
@Table
public class UserTickets {
    @PrimaryKey
    private UUID id;

    @Column
    private String name;

    @Column
    private String surname;

    @Column
    private String ticketid;

    @Column
    private VerifyTypes verifyType;
}
