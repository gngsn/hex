package com.gngsn.ditto.port.output;

import com.gngsn.ditto.adapter.output.persistence.entity.ArticleEntity
import com.gngsn.ditto.domain.Article
import com.gngsn.ditto.shared.model.PagingCommand

interface ArticlePersistencePort {
    fun findAll(pagingCommand: PagingCommand): List<ArticleEntity>

    fun save(article: Article)
}
