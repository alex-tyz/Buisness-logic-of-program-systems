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
public class City {

    @PrimaryKey
    private String id;

    @Column
    private String name;

    @Column
    private float rating;
}