package com.gngsn.hex.adapter.output.console

import com.gngsn.hex.port.output.PrintConsoleOutputPort

class PrintConsoleAdapter : PrintConsoleOutputPort {

    override fun print(text: String) {
        println(text)
    }
}