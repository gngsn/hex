package com.gngsn.hex

import com.gngsn.hex.domain.Article
import jakarta.persistence.EntityManagerFactory
import jakarta.persistence.Persistence
import org.springframework.boot.ApplicationArguments
import org.springframework.boot.ApplicationRunner


class HibernateTest : ApplicationRunner {


    fun storeLoadMessage() {
        val entityManagerFactory: EntityManagerFactory = Persistence.createEntityManagerFactory("hibernate-test")

        entityManagerFactory.createEntityManager().use {
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

    override fun run(args: ApplicationArguments?) {
        storeLoadMessage()
    }
}