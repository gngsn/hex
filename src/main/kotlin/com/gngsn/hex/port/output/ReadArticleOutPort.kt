package com.gngsn.hex.port.output

import com.gngsn.hex.adapter.output.persistence.entity.ArticleEntity
import com.gngsn.hex.shared.model.PagingCommand

interface ReadArticleOutPort {
    fun findAll(pagingCommand: PagingCommand): List<ArticleEntity>
}
