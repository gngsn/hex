package com.gngsn.ditto.application.markdown

import com.gngsn.ditto.port.input.LocalFileReadPort
import com.gngsn.ditto.port.output.GithubFeignClientPort
import com.gngsn.ditto.shared.support.UseCase

@UseCase
class GetRenderedMarkdownUseCase(
    val localFileReadPort: LocalFileReadPort,
    val githubFeignClientPort: GithubFeignClientPort
) {

    fun render(): String =
        githubFeignClientPort.renderMarkdown(
            GithubFeignClientPort.RenderRequestBody(
                localFileReadPort.readAllFiles().joinToString("\n")
            )
        )
}
