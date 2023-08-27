package com.gngsn.hex.application.article.usecase

import com.gngsn.hex.adapter.extension.toVO
import com.gngsn.hex.domain.Article
import com.gngsn.hex.port.input.GetArticleInputPort
import com.gngsn.hex.port.output.ReadArticleOutPort
import com.gngsn.hex.shared.model.PagingCommand
import com.gngsn.hex.shared.support.UseCase

@UseCase
class GetArticleListUseCase(
    val articlePersistencePort: ReadArticleOutPort
) : GetArticleInputPort {
    
    override fun get(pagingCommand: PagingCommand): List<Article> {
        return articlePersistencePort.findAll(pagingCommand).map { it.toVO() }
    }
}
