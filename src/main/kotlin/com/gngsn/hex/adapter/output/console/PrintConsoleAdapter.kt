package com.gngsn.hex.adapter.output.console

import com.gngsn.hex.port.output.PrintConsoleOutputPort
import com.gngsn.hex.shared.support.Adapter

@Adapter
class PrintConsoleAdapter : PrintConsoleOutputPort {

    override fun print(text: String) {
        println(text)
    }
}