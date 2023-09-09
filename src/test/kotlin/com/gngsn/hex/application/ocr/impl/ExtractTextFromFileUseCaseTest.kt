package com.gngsn.hex.application.ocr.impl

import com.gngsn.hex.adapter.input.file.ImageFileReaderAdapter
import com.gngsn.hex.adapter.output.console.PrintConsoleAdapter
import net.sourceforge.tess4j.Tesseract
import org.junit.jupiter.api.Test

class ExtractTextFromFileUseCaseTest {
    @Test
    fun readAndWrite() {
        ExtractTextFromFileUseCase(
            ImageFileReaderAdapter(),
            PrintConsoleAdapter(),
            Tesseract()
        ).readAndWrite()
    }
}