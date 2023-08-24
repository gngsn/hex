package com.gngsn.ditto.port.input

import com.gngsn.ditto.domain.Article
import com.gngsn.ditto.shared.model.PagingCommand

interface GetArticleInputPort {

    fun get(pagingCommand: PagingCommand): List<Article>
}
