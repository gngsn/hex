package com.gngsn.ditto.adapter.output.persistence.repository

import com.gngsn.ditto.adapter.output.persistence.entity.ArticleEntity
import jakarta.persistence.EntityManager
import org.springframework.stereotype.Repository

@Repository
class ArticleMasterRepository (
    private val em: EntityManager,
) {
    fun save(articleEntity: ArticleEntity) {
        return em.persist(articleEntity)
    }
}