package com.gngsn.hex.application.markdown

import com.gngsn.hex.port.input.ReadRenderedMdFileInputPort
import com.gngsn.hex.port.output.ReadFileInputPort
import com.gngsn.hex.port.output.RenderToHtmlOutPort
import com.gngsn.hex.shared.support.UseCase

@UseCase
class GetRenderedMarkdownUseCase(
    val readFileInputPort: ReadFileInputPort,
    val renderToHtmlOutPort: RenderToHtmlOutPort
) : ReadRenderedMdFileInputPort {

    override fun get(name: String): String = renderToHtmlOutPort.render(
        RenderToHtmlOutPort.RenderRequestBody(
            readFileInputPort.read().joinToString("\n")
        )
    )
}
