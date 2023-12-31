package com.gngsn.hex.querydsl

import com.gngsn.hex.adapter.output.persistence.entity.ArticleEntity
import com.gngsn.hex.adapter.output.persistence.entity.QArticleEntity.articleEntity
import com.gngsn.hex.adapter.output.persistence.repository.ArticleMasterRepository
import com.gngsn.hex.adapter.output.persistence.repository.ArticleSlaveRepository
import com.gngsn.hex.testsupporter.AbstractTestContainerSupporter
import com.querydsl.jpa.impl.JPAQueryFactory
import io.mockk.mockk
import jakarta.persistence.EntityManager
import jakarta.transaction.Transactional
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Assertions.assertNotNull
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertAll
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager
import java.time.LocalDateTime

@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
class JpaQuerydslTest(
    @Autowired private val testEntityManager: TestEntityManager
) {
    private val entityManager: EntityManager = testEntityManager.entityManager
    private lateinit var masterRepository: ArticleMasterRepository
    private lateinit var slaveRepository: ArticleSlaveRepository

    @BeforeEach
    fun setup() {
        masterRepository = mockk()
        slaveRepository = mockk()

        val articleEntity = ArticleEntity(null, "새로운 게시글", "내용입니다", "sunny", LocalDateTime.now(), LocalDateTime.now())
        entityManager.persist(articleEntity)
    }

    @Test
    @Transactional
    fun select_article() {
        val query = JPAQueryFactory(entityManager)

        val fetchArticle: ArticleEntity? = query.selectFrom(articleEntity)
            .where(articleEntity.title.eq("새로운 게시글"))
            .fetchOne()

        print(fetchArticle)

        assertAll(
            { assertNotNull(fetchArticle) },
            { assertEquals("sunny", fetchArticle?.author) },
        )
    }
}