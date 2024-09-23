package org.senechka.lab1.models;

import com.itextpdf.layout.element.Link;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.cassandra.core.mapping.Column;
import org.springframework.data.cassandra.core.mapping.PrimaryKey;
import org.springframework.data.cassandra.core.mapping.Table;

import java.util.UUID;

@Table
@NoArgsConstructor
@Setter
@Getter
public class Transaction {
    @PrimaryKey
    private UUID id;

    @Column
    private String state;

    @Column
    private String link;
}
