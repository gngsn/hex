package com.gngsn.ditto.adapter.external

import com.gngsn.ditto.adapter.output.persistence.ArticlePersistenceAdapter
import com.gngsn.ditto.adapter.output.persistence.repository.ArticleMasterRepository
import com.gngsn.ditto.adapter.output.persistence.repository.ArticleSlaveRepository
import com.gngsn.ditto.domain.Article
import com.gngsn.ditto.shared.model.PagingCommand
import io.mockk.impl.annotations.MockK
import io.mockk.junit5.MockKExtension
import io.mockk.verify
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.extension.ExtendWith


@ExtendWith(MockKExtension::class)
class JpaQuerydslTest {
    @MockK lateinit var articleMasterRepository: ArticleMasterRepository
    @MockK lateinit var articleSlaveRepository: ArticleSlaveRepository
    private lateinit var articlePersistenceAdapter: ArticlePersistenceAdapter

    @BeforeEach
    fun setup() {
        articlePersistenceAdapter = ArticlePersistenceAdapter(articleMasterRepository, articleSlaveRepository)
    }

    @Test
    fun select_article() {
        val article = Article( "새로운 게시글", "내용입니다", "sunny")
            articlePersistenceAdapter.save(article)
        verify {
            val list = articlePersistenceAdapter.findAll(PagingCommand())
            list.get(0).equals(article)
        }
    }
}