package org.senechka.lab1.models;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.cassandra.core.mapping.Column;
import org.springframework.data.cassandra.core.mapping.PrimaryKey;
import org.springframework.data.cassandra.core.mapping.Table;

@Getter
@Setter
@AllArgsConstructor
@Table
public class Authorities {
    @Column
    @PrimaryKey
    private String username;

    @Column
    private Roles role;
}
