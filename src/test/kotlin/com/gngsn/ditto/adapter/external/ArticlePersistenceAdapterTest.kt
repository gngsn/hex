package com.gngsn.ditto.adapter.external

import com.gngsn.ditto.adapter.external.persistence.entity.ArticleEntity
import com.gngsn.ditto.adapter.external.persistence.entity.QArticleEntity
import com.gngsn.ditto.adapter.external.persistence.repository.ArticleMasterRepository
import com.gngsn.ditto.adapter.external.persistence.repository.ArticleSlaveRepository
import com.querydsl.jpa.impl.JPAQuery
import io.mockk.mockk
import jakarta.persistence.EntityManager
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Assertions.assertNotNull
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertAll
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager


@DataJpaTest
class ArticlePersistenceAdapterTest (
    @Autowired private val testEntityManager: TestEntityManager
){
    private lateinit var entityManager: EntityManager
    private val masterRepository: ArticleMasterRepository = mockk()
    private val slaveRepository: ArticleSlaveRepository = mockk()

    @BeforeEach
    fun setup() {
        entityManager = testEntityManager.entityManager
    }

    @Test
    fun tt() {
        val query: JPAQuery<ArticleEntity> = JPAQuery(entityManager)
        val qArticle = QArticleEntity.articleEntity

        val fetchArticle: ArticleEntity? = query.from(qArticle)
            .where(qArticle.title.eq("새로운 게시글"))
            .fetchOne()

        print(fetchArticle)

        assertAll(
            { assertNotNull(fetchArticle) },
            { assertEquals("sunny", fetchArticle?.author) },
        )
    }
}