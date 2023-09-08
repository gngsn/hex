package com.gngsn.hex.adapter.input.file

import com.gngsn.hex.port.output.ReadFileInputPort
import com.gngsn.hex.shared.support.Adapter
import java.io.File

@Adapter
class MarkdownFileReaderAdapter : ReadFileInputPort {

    override fun read(): List<String> =
        File("data/").walk()
            .filter { it.isFile }
            .map { it.readLines().joinToString("\n") }
            .toList()
}