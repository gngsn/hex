package com.gngsn.ditto.port.output

import com.gngsn.ditto.adapter.output.persistence.entity.ArticleEntity
import com.gngsn.ditto.shared.model.PagingCommand

interface ReadArticleOutPort {
    fun findAll(pagingCommand: PagingCommand): List<ArticleEntity>
}
