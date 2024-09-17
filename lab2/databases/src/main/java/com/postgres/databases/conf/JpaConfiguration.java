package com.postgres.databases.conf;



import javax.sql.DataSource;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jdbc.repository.config.EnableJdbcRepositories;

@Configuration
@EnableJdbcRepositories
public class JpaConfiguration {

}
