package com.fullstack;


import org.flywaydb.core.Flyway;
import org.junit.jupiter.api.Test;

import java.util.Locale;

import static org.assertj.core.api.Assertions.assertThat;


public class TestContainersTest extends AbstractTestContainer {
    @Test
    void canStartPostgresDB() {
        assertThat(postgresContainer.isRunning()).isTrue();
        assertThat(postgresContainer.isCreated()).isTrue();
    }

}