package com.gngsn.ditto.port.output;

interface GithubFeignClientPort {

    fun renderMarkdown(body: RenderRequestBody): String

    data class RenderRequestBody(
        val text: String
    )
}
