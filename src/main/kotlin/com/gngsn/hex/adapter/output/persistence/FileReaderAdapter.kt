package com.gngsn.hex.adapter.output.persistence

import com.gngsn.hex.port.output.ReadFileOutputPort
import com.gngsn.hex.shared.support.Adapter
import java.io.File

@Adapter
class FileReaderAdapter : ReadFileOutputPort {

    override fun read(): List<String> =
        File("data/").walk()
            .filter { it.isFile }
            .map { it.readLines().joinToString("\n") }
            .toList()
}