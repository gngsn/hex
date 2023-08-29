package com.gngsn.hex.testsupporter

import org.junit.jupiter.api.AfterAll
import org.junit.jupiter.api.BeforeAll
import org.junit.jupiter.api.BeforeEach
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest
import org.springframework.context.annotation.Profile
import org.testcontainers.containers.PostgreSQLContainer;


@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
abstract class AbstractTestContainerSupporter {
    companion object {
        lateinit var connectionProvider: DBConnectionProvider
        private var postgres: PostgreSQLContainer<*> = PostgreSQLContainer(
            "postgres:15-alpine"
        )

        @BeforeAll
        fun beforeAll() {
            postgres.start()
        }

        @AfterAll
        fun afterAll(): Unit {
            postgres.stop()
        }

        @BeforeEach
        fun setUp() {
            connectionProvider = DBConnectionProvider(
                postgres.getJdbcUrl(),
                postgres.getUsername(),
                postgres.getPassword()
            )
        }
    }
}