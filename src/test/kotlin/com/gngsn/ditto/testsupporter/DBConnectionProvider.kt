package com.gngsn.ditto.testsupporter

import java.sql.Connection
import java.sql.DriverManager


class DBConnectionProvider(
    private val url: String,
    private val username: String,
    private val password: String
) {

    val connection: Connection
        get() = try {
            DriverManager.getConnection(url, username, password)
        } catch (e: Exception) {
            throw RuntimeException(e)
        }
}