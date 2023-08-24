package com.gngsn.ditto.application.article

import com.gngsn.ditto.adapter.output.persistence.entity.ArticleEntity
import com.gngsn.ditto.application.article.usecase.GetArticleListUseCase
import com.gngsn.ditto.port.output.ReadArticleOutPort
import com.gngsn.ditto.shared.model.PagingCommand
import com.gngsn.ditto.testsupporter.AbstractTestContainerSupporter
import io.mockk.MockKAnnotations
import io.mockk.every
import io.mockk.impl.annotations.InjectMockKs
import io.mockk.impl.annotations.MockK
import io.mockk.mockkClass
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test

class GetArticleListUseCaseTest : AbstractTestContainerSupporter() {

    @MockK
    lateinit var articlePersistencePort: ReadArticleOutPort

    @InjectMockKs
    lateinit var getArticleListUseCase: GetArticleListUseCase

    @BeforeEach
    fun setUp() = MockKAnnotations.init(this)

    @Test
    fun shouldGetCustomers() {
        val pagingCommand = PagingCommand(0, 10)
        val articleEntities = listOf(
            mockkClass(ArticleEntity::class),
            mockkClass(ArticleEntity::class),
            mockkClass(ArticleEntity::class),
            mockkClass(ArticleEntity::class),
            mockkClass(ArticleEntity::class)
        )
        every { articlePersistencePort.findAll(pagingCommand) } returns articleEntities

        val list = getArticleListUseCase.get(pagingCommand)

        for ((i, article) in list.withIndex()) {
            assertEquals(articleEntities[i].content, article.content)
        }
    }
}

