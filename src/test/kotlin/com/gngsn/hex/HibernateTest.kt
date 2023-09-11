package com.gngsn.hex

import com.gngsn.hex.domain.Article
import com.gngsn.hex.testsupporter.AbstractTestContainerSupporter
import jakarta.persistence.EntityManager
import jakarta.persistence.PersistenceContext
import org.junit.jupiter.api.Test
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest
import org.springframework.test.context.TestPropertySource


@DataJpaTest
@TestPropertySource(locations = ["/application.yml"])
class HibernateTest : AbstractTestContainerSupporter() {
    @PersistenceContext
    lateinit var entityManager: EntityManager
//    private val entityManagerFactory: EntityManagerFactory = testEntityManager.entityManagerFactory


    @Test
    fun storeLoadMessage() {
//        val entityManager = entityManagerFactory.createEntityManager()
        entityManager.use {
            it.transaction.begin()

            val message: Article = Article("title", "content", "sun.ny")

            it.persist(message)
            it.transaction.commit()

            val articles = it.createQuery("select a from Article a", Article::class.java).resultList
            articles.forEach { article ->
                println(article)
                article.content = "change!"
            }

            it.transaction.commit()

            articles.forEach { article -> println(article) }
            it.close()
        }
    }
}