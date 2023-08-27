package com.gngsn.hex.application.markdown

import com.gngsn.hex.port.input.ReadRenderedMdFileInputPort
import com.gngsn.hex.port.output.ReadFileOutputPort
import com.gngsn.hex.port.output.RenderToHtmlOutPort
import com.gngsn.hex.shared.support.UseCase

@UseCase
class GetRenderedMarkdownUseCase(
    val readFileOutputPort: ReadFileOutputPort,
    val renderToHtmlOutPort: RenderToHtmlOutPort
) : ReadRenderedMdFileInputPort {

    override fun get(name: String): String = renderToHtmlOutPort.render(
        RenderToHtmlOutPort.RenderRequestBody(
            readFileOutputPort.read().joinToString("\n")
        )
    )
}
