package com.gngsn.ditto.application.article.usecase

import com.gngsn.ditto.domain.Article
import com.gngsn.ditto.shared.model.PagingCommand

interface GetArticleUseCase {
    fun getList(pagingCommand: PagingCommand): List<Article>
}
