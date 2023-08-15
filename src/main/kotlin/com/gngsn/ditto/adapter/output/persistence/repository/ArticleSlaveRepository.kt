package com.gngsn.ditto.adapter.output.persistence.repository

import com.gngsn.ditto.adapter.output.persistence.entity.ArticleEntity
import com.gngsn.ditto.adapter.output.persistence.entity.QArticleEntity.articleEntity
import com.querydsl.jpa.impl.JPAQueryFactory
import org.springframework.stereotype.Repository

@Repository
class ArticleSlaveRepository(
    private val jpaQueryFactory: JPAQueryFactory
) {
    fun find(author: String): ArticleEntity? {
        return jpaQueryFactory
            .selectFrom(articleEntity)
            .where(articleEntity.author.eq(author))
            .fetchOne()
    }

    fun findAllByAuthor(author: String): List<ArticleEntity> {
        return jpaQueryFactory
            .selectFrom(articleEntity)
            .where(articleEntity.author.eq(author))
            .fetch()
    }

    fun findAllByAuthorWithPaging(author: String, offset: Long, limit: Long): List<ArticleEntity> {
        return jpaQueryFactory
            .selectFrom(articleEntity)
            .offset(offset)
            .limit(limit)
            .where(articleEntity.author.eq(author))
            .fetch()
    }
}