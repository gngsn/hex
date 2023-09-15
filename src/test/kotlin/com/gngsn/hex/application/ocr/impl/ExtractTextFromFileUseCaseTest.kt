package com.gngsn.hex.application.ocr.impl

import com.gngsn.hex.adapter.input.file.ImageFileReaderAdapter
import com.gngsn.hex.adapter.output.console.PrintConsoleAdapter
import net.sourceforge.tess4j.Tesseract
import org.junit.jupiter.api.Test


class ExtractTextFromFileUseCaseTest {

    @Test
    fun readAndWrite() {
        val tesseract = Tesseract()
        tesseract.setDatapath("/opt/homebrew/Cellar/tesseract/5.3.2_1/bin/tesseract")
        ExtractTextFromFileUseCase(
            ImageFileReaderAdapter(),
            PrintConsoleAdapter(),
            tesseract
        ).readAndWrite()
    }
}