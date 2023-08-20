package com.gngsn.ditto.adapter.input.web

import com.gngsn.ditto.adapter.output.ArticlePersistenceAdapter
import com.gngsn.ditto.adapter.output.persistence.entity.ArticleEntity
import com.gngsn.ditto.adapter.output.persistence.repository.ArticleMasterRepository
import com.gngsn.ditto.adapter.output.persistence.repository.ArticleSlaveRepository
import com.gngsn.ditto.application.article.mapper.toVO
import com.gngsn.ditto.application.article.usecase.GetArticleListUseCase
import com.gngsn.ditto.shared.model.PagingCommand
import com.ninjasquad.springmockk.MockkBean
import io.mockk.every
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest
import org.springframework.http.MediaType
import org.springframework.test.web.servlet.MockMvc
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get
import org.springframework.test.web.servlet.result.MockMvcResultMatchers.*
import java.time.LocalDateTime

@WebMvcTest
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
        val article1 = ArticleEntity( null, "새로운 게시글 1", "내용입니다", "sunny", LocalDateTime.now(), LocalDateTime.now())
        val article2 = ArticleEntity( null, "새로운 게시글 2", "내용입니다", "sunny", LocalDateTime.now(), LocalDateTime.now())
        val article3 = ArticleEntity( null, "새로운 게시글 3", "내용입니다", "sunny", LocalDateTime.now(), LocalDateTime.now())

        every {
            getArticleListUseCase.execute(PagingCommand())
        } returns listOf(article1, article2, article3).map { it.toVO() }
    }

    @Test
    fun `List articles`() {
        mockMvc.perform(get("/blog?page=0&size=10").accept(MediaType.APPLICATION_JSON))
            .andExpect(status().isOk)
            .andExpect(content().contentType(MediaType.APPLICATION_JSON))
            .andExpect(jsonPath("\$.[0].title").value("새로운 게시글 1"))
            .andExpect(jsonPath("\$.[0].content").value("내용입니다"))
            .andExpect(jsonPath("\$.[0].author").value("sunny"))
    }
}