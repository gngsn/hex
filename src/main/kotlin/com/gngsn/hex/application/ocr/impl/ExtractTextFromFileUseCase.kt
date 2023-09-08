package com.gngsn.hex.application.ocr.impl

import com.gngsn.hex.application.ocr.IExtractTextFromFileUseCase
import com.gngsn.hex.port.input.GetFileInputPort
import com.gngsn.hex.port.output.PrintConsoleOutputPort
import com.gngsn.hex.shared.support.UseCase
import net.sourceforge.tess4j.Tesseract


@UseCase
class ExtractTextFromFileUseCase(
    private val getFileInputPort: GetFileInputPort,
    private val printConsoleOutputPort: PrintConsoleOutputPort,
    private val tesseract: Tesseract = Tesseract()
) : IExtractTextFromFileUseCase {

    override fun readAndWrite() {
        tesseract.setDatapath("src/main/resources/tessdata")
        tesseract.setLanguage("eng")
        tesseract.setPageSegMode(1)
        tesseract.setOcrEngineMode(1)

        val text: String = tesseract.doOCR(getFileInputPort.get())
        printConsoleOutputPort.print("Extract text: $text")
    }
}