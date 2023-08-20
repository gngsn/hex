package com.gngsn.ditto.adapter.input.file

import com.gngsn.ditto.port.input.LocalFileReadPort
import com.gngsn.ditto.shared.support.Adapter
import java.io.File

@Adapter
class FileReaderAdapter: LocalFileReadPort {

    override fun readAllFiles(): List<String> =
        File("data/").walk()
            .filter { it.isFile }
            .map { it.readLines().joinToString("\n") }
            .toList()
}