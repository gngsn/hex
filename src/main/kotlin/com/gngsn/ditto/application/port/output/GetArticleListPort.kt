package com.gngsn.ditto.application.port.output;

import com.gngsn.ditto.adapter.external.persistence.entity.ArticleEntity
import com.gngsn.ditto.shared.model.PagingCommand

interface GetArticleListPort {
    fun findAll(pagingCommand: PagingCommand): List<ArticleEntity>
}
