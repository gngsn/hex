package com.gngsn.ditto.application.port.output;

import com.gngsn.ditto.adapter.external.persistence.entity.ArticleEntity
import org.springframework.data.domain.Page
import org.springframework.data.domain.Pageable

interface GetArticleListPort {
    fun findAll(pageable: Pageable): Page<ArticleEntity>
}
