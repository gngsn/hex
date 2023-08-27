package com.gngsn.hex.port.output

interface RenderToHtmlOutPort {

    fun render(body: RenderRequestBody): String

    data class RenderRequestBody(
        val text: String
    )
}
