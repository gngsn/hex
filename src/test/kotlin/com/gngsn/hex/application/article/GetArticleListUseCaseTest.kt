package com.gngsn.hex.application.article

import com.gngsn.hex.application.article.usecase.GetArticleListUseCase
import com.gngsn.hex.domain.Article
import com.gngsn.hex.port.output.ReadArticleOutPort
import com.gngsn.hex.testsupporter.AbstractTestContainerSupporter
import io.mockk.MockKAnnotations
import io.mockk.every
import io.mockk.impl.annotations.InjectMockKs
import io.mockk.impl.annotations.MockK
import io.mockk.mockkClass
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test
import org.springframework.data.domain.Pageable

class GetArticleListUseCaseTest : AbstractTestContainerSupporter() {

    @MockK
    lateinit var articlePersistencePort: ReadArticleOutPort

    @InjectMockKs
    lateinit var getArticleListUseCase: GetArticleListUseCase

    @BeforeEach
    fun setUp() = MockKAnnotations.init(this)

    @Test
    fun shouldGetCustomers() {
        val paging = Pageable.ofSize(10)
        val articles = listOf(
            mockkClass(Article::class),
            mockkClass(Article::class),
            mockkClass(Article::class),
            mockkClass(Article::class),
            mockkClass(Article::class)
        )
        every { articlePersistencePort.findAll("sunny", paging) } returns articles

        val list = getArticleListUseCase.get("sunny", paging)

        for ((i, article) in list.withIndex()) {
            assertEquals(articles[i].content, article.content)
        }
    }
}

