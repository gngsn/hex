package com.gngsn.ditto.application.article

import com.gngsn.ditto.application.markdown.GetRenderedMarkdownUseCase
import com.gngsn.ditto.port.output.ReadFileOutputPort
import com.gngsn.ditto.port.output.RenderToHtmlOutPort
import io.mockk.MockKAnnotations
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest

@SpringBootTest
class GetRenderedMarkdownUseCaseTest(
    @Autowired val readFileOutputPort: ReadFileOutputPort,
    @Autowired val renderToHtmlOutPort: RenderToHtmlOutPort,
    @Autowired val getRenderedMarkdownUseCase: GetRenderedMarkdownUseCase
) {
    
    @BeforeEach
    fun setUp() = MockKAnnotations.init(this)

    @Test
    fun render() {
        val render = getRenderedMarkdownUseCase.get("Design-By-Contract.md")
        println(render)
    }
}