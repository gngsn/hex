package com.gngsn.ditto.port.output

interface RenderToHtmlOutPort {

    fun render(body: RenderRequestBody): String

    data class RenderRequestBody(
        val text: String
    )
}
