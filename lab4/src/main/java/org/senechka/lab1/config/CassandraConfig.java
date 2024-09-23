package org.senechka.lab1.config;

import io.micrometer.common.lang.NonNullApi;
import lombok.NonNull;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.cassandra.config.AbstractCassandraConfiguration;
import org.springframework.data.cassandra.repository.config.EnableCassandraRepositories;

@Configuration
@EnableCassandraRepositories
public class CassandraConfig extends AbstractCassandraConfiguration {

    @Override
    protected String getKeyspaceName() {
        return "blps";
    }
/* server
    @Override
    protected String getContactPoints() {
        return "cassandra/localhost";
    }*/
    @Override
    protected String getContactPoints() {
        return "cassandra";
    }

    @Override
    protected int getPort() {
        return 9042;
    }

}
