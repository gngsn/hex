package com.gngsn.ditto.port.output;

import com.gngsn.ditto.adapter.output.persistence.entity.ArticleEntity
import com.gngsn.ditto.shared.model.PagingCommand

interface GetArticleListPort {
    fun findAll(pagingCommand: PagingCommand): List<ArticleEntity>
}
