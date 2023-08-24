package com.gngsn.ditto.application.article.usecase

import com.gngsn.ditto.adapter.extension.toVO
import com.gngsn.ditto.domain.Article
import com.gngsn.ditto.port.input.GetArticleInputPort
import com.gngsn.ditto.port.output.ReadArticleOutPort
import com.gngsn.ditto.shared.model.PagingCommand
import com.gngsn.ditto.shared.support.UseCase

@UseCase
class GetArticleListUseCase(
    val articlePersistencePort: ReadArticleOutPort
) : GetArticleInputPort {
    
    override fun get(pagingCommand: PagingCommand): List<Article> {
        return articlePersistencePort.findAll(pagingCommand).map { it.toVO() }
    }
}
