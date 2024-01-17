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

    @Test
    fun aa() {
        val str1 = "test"
        val str2 = "test"
        val str3 = java.lang.String("test")

        println(str1.equals(str3))
    }
}