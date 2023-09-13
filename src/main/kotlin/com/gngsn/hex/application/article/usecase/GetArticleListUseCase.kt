package com.gngsn.hex.application.article.usecase

import com.gngsn.hex.domain.Article
import com.gngsn.hex.port.input.GetArticleInputPort
import com.gngsn.hex.port.output.ReadArticleOutPort
import com.gngsn.hex.shared.support.UseCase
import org.springframework.data.domain.Pageable

@UseCase
class GetArticleListUseCase(
    val articlePersistencePort: ReadArticleOutPort
) : GetArticleInputPort {

    override fun get(author: String, pageable: Pageable): List<Article> {
        return articlePersistencePort.findAll(author, pageable)
    }
}
