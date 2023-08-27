package com.gngsn.hex.port.input

import com.gngsn.hex.domain.Article
import com.gngsn.hex.shared.model.PagingCommand

interface GetArticleInputPort {

    fun get(pagingCommand: PagingCommand): List<Article>
}
