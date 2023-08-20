package com.gngsn.ditto.application.article.usecase

import com.gngsn.ditto.application.markdown.GetRenderedMarkdownUseCase
import com.gngsn.ditto.port.input.LocalFileReadPort
import com.gngsn.ditto.port.output.GithubFeignClientPort
import io.mockk.MockKAnnotations
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest

@SpringBootTest
class GetRenderedMarkdownUseCaseTest(
    @Autowired val localFileReadPort: LocalFileReadPort,
    @Autowired val githubFeignClientPort: GithubFeignClientPort,
    @Autowired val getRenderedMarkdownUseCase: GetRenderedMarkdownUseCase
) {

//    @MockK
//    lateinit var githubFeignAdapter: GithubFeignAdapter
//
//    @MockK
//    lateinit var fileReaderAdapter: FileReaderAdapter

//    @InjectMockKs
//    lateinit var getArticleListFromFilesCase: GetArticleListFromFilesCase

    @BeforeEach
    fun setUp() = MockKAnnotations.init(this)

    @Test
    fun render() {
        val render = getRenderedMarkdownUseCase.render()
        println(render)
    }
}