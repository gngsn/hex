package com.gngsn.ditto.adapter.input.web

import com.gngsn.ditto.adapter.extension.toVO
import com.gngsn.ditto.adapter.output.persistence.ArticlePersistenceAdapter
import com.gngsn.ditto.adapter.output.persistence.entity.ArticleEntity
import com.gngsn.ditto.adapter.output.persistence.repository.ArticleMasterRepository
import com.gngsn.ditto.adapter.output.persistence.repository.ArticleSlaveRepository
import com.gngsn.ditto.application.article.usecase.GetArticleListUseCase
import com.gngsn.ditto.shared.model.PagingCommand
import com.ninjasquad.springmockk.MockkBean
import io.mockk.every
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.test.web.servlet.MockMvc
import java.time.LocalDateTime

@SpringBootTest
@AutoConfigureMockMvc
class ArticleRouteAdapterTest(@Autowired val mockMvc: MockMvc) {

    @MockkBean
    lateinit var articleMasterRepository: ArticleMasterRepository

    @MockkBean
    lateinit var articleSlaveRepository: ArticleSlaveRepository

    @MockkBean
    lateinit var articlePersistenceAdapter: ArticlePersistenceAdapter

    @MockkBean
    lateinit var getArticleListUseCase: GetArticleListUseCase

    @BeforeEach
    fun setup() {
        val article1 = ArticleEntity(null, "새로운 게시글 1", "내용입니다", "sunny", LocalDateTime.now(), LocalDateTime.now())
        val article2 = ArticleEntity(null, "새로운 게시글 2", "내용입니다", "sunny", LocalDateTime.now(), LocalDateTime.now())
        val article3 = ArticleEntity(null, "새로운 게시글 3", "내용입니다", "sunny", LocalDateTime.now(), LocalDateTime.now())

        every {
            getArticleListUseCase.get(PagingCommand())
        } returns listOf(article1, article2, article3).map { it.toVO() }
    }

    @Test
    fun `List articles`() {
    }
}