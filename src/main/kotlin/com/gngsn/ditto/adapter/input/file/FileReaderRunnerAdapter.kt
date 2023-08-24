package com.gngsn.ditto.adapter.input.file

import com.gngsn.ditto.port.input.ReadRenderedMdFileInputPort
import com.gngsn.ditto.shared.support.Adapter
import org.springframework.boot.ApplicationArguments
import org.springframework.boot.ApplicationRunner

@Adapter
class FileReaderRunnerAdapter(
    val readRenderedMdFileInputPort: ReadRenderedMdFileInputPort
) : ApplicationRunner {

    override fun run(args: ApplicationArguments?) {
        readRenderedMdFileInputPort.get("Design-By-Contract.md")
    }
}