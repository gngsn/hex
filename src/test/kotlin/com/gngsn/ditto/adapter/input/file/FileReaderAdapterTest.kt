package com.gngsn.ditto.adapter.input.file

import org.junit.jupiter.api.Test

class FileReaderAdapterTest {

    @Test
    fun readAllFiles() {
        val fileReaderAdapter = FileReaderAdapter()
        fileReaderAdapter.readAllFiles().forEach {
            println(it)
        }
    }
}