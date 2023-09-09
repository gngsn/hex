package com.gngsn.hex.adapter.input.file

import com.gngsn.hex.port.input.GetFileInputPort
import com.gngsn.hex.shared.support.Adapter
import java.io.File

@Adapter
class ImageFileReaderAdapter : GetFileInputPort {

    override fun get(): File {
        return File("data/ocr-test.png")
    }
}