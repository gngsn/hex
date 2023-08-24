package com.gngsn.ditto.adapter.output.persistence

import com.gngsn.ditto.port.output.ReadFileOutputPort
import com.gngsn.ditto.shared.support.Adapter
import java.io.File

@Adapter
class FileReaderAdapter : ReadFileOutputPort {

    override fun read(): List<String> =
        File("data/").walk()
            .filter { it.isFile }
            .map { it.readLines().joinToString("\n") }
            .toList()
}