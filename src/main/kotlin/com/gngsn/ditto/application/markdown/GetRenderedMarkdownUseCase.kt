package com.gngsn.ditto.application.markdown

import com.gngsn.ditto.port.input.ReadRenderedMdFileInputPort
import com.gngsn.ditto.port.output.ReadFileOutputPort
import com.gngsn.ditto.port.output.RenderToHtmlOutPort
import com.gngsn.ditto.shared.support.UseCase

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
