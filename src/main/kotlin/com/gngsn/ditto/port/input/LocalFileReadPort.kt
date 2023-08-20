package com.gngsn.ditto.port.input

interface LocalFileReadPort {
    fun readAllFiles(): List<String>
}
