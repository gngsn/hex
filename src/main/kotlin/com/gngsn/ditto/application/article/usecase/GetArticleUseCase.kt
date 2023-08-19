package com.gngsn.ditto.application.article.usecase

import com.gngsn.ditto.application.article.mapper.toVO
import com.gngsn.ditto.domain.Article
import com.gngsn.ditto.port.output.GetArticleListPort
import com.gngsn.ditto.shared.model.PagingCommand
import com.gngsn.ditto.shared.support.UseCase

@UseCase
class GetArticleUseCase(
    val getArticleListPort: GetArticleListPort
) {
    fun getList(pagingCommand: PagingCommand): List<Article> {
        return getArticleListPort.findAll(pagingCommand).map { it.toVO() }
    }
}
