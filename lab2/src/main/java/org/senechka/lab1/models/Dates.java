package org.senechka.lab1.models;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.cassandra.core.mapping.Column;
import org.springframework.data.cassandra.core.mapping.PrimaryKey;
import org.springframework.data.cassandra.core.mapping.Table;

import java.sql.Date;
import java.util.UUID;

@Getter
@Setter
@AllArgsConstructor
@Table
public class Dates {

    @PrimaryKey
    private UUID id;

    @Column
    private Date date;

    @Column
    private boolean isFree;

    @Column
    private String fromCity;

    @Column
    private String toCity;

    @Column
    private int cost;
}