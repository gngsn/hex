package com.gngsn.ditto.application.article.usecase

import com.gngsn.ditto.adapter.extension.toVO
import com.gngsn.ditto.domain.Article
import com.gngsn.ditto.port.output.ArticlePersistencePort
import com.gngsn.ditto.shared.model.PagingCommand
import com.gngsn.ditto.shared.support.UseCase

@UseCase
class GetArticleListUseCase(
    val articlePersistencePort: ArticlePersistencePort
) {
    fun execute(pagingCommand: PagingCommand): List<Article> {
        return articlePersistencePort.findAll(pagingCommand).map { it.toVO() }
    }
}
