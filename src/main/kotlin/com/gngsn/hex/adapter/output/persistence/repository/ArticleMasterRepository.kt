package com.gngsn.hex.adapter.output.persistence.repository

import com.gngsn.hex.adapter.output.persistence.entity.ArticleEntity
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