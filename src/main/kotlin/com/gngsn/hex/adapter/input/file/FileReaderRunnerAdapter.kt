package com.gngsn.hex.adapter.input.file

import com.gngsn.hex.port.input.ReadRenderedMdFileInputPort
import com.gngsn.hex.shared.support.Adapter
import org.springframework.boot.ApplicationArguments
import org.springframework.boot.ApplicationRunner

@Adapter
class FileReaderRunnerAdapter(
    val readRenderedMdFileInputPort: ReadRenderedMdFileInputPort
) : ApplicationRunner {

    override fun run(args: ApplicationArguments?) {
        readRenderedMdFileInputPort.get("Testing-Style.md")
    }
}