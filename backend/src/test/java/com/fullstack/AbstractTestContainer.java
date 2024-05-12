package com.fullstack;

import com.github.javafaker.Faker;
import org.flywaydb.core.Flyway;
import org.junit.jupiter.api.BeforeAll;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.test.context.DynamicPropertyRegistry;
import org.springframework.test.context.DynamicPropertySource;
import org.testcontainers.containers.PostgreSQLContainer;
import org.testcontainers.junit.jupiter.Container;
import org.testcontainers.junit.jupiter.Testcontainers;

import javax.sql.DataSource;

@Testcontainers
public abstract class AbstractTestContainer {
    @Container
    protected static final PostgreSQLContainer<?> postgresContainer = new PostgreSQLContainer<>("postgres:latest").
            withDatabaseName("amigoscode-dao-unit-test")
            .withUsername("postgres")
            .withPassword("postgres");
    protected static final Faker faker = new Faker();

    @BeforeAll
    static void beforeall() {
        Flyway flyway = Flyway.configure().dataSource(
                postgresContainer.getJdbcUrl(),
                postgresContainer.getUsername(),
                postgresContainer.getPassword()
        ).load();
        flyway.migrate();
    }

    @DynamicPropertySource
    private static void registerDataSourceProperty(DynamicPropertyRegistry registry) {
        registry.add(
                "spring.datasource.url",
                postgresContainer::getJdbcUrl
        );
        registry.add(
                "spring.datasource.username",
                postgresContainer::getUsername
        );
        registry.add(
                "spring.datasource.password",
                postgresContainer::getPassword
        );

    }

    private static DataSource batasource() {
        return DataSourceBuilder.create().
                driverClassName(postgresContainer.getDriverClassName()).
                url(postgresContainer.getJdbcUrl()).
                username(postgresContainer.getUsername())
                .password(postgresContainer.getPassword())
                .build();
    }

    protected static JdbcTemplate getJdbcTemplate() {
        return new JdbcTemplate(batasource());
    }


}
