package com.gngsn.hex.testsupporter

import org.junit.jupiter.api.AfterAll
import org.junit.jupiter.api.BeforeAll
import org.junit.jupiter.api.BeforeEach
import org.testcontainers.containers.PostgreSQLContainer;


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