package com.gngsn.ditto.application.article.service;

import com.gngsn.ditto.application.article.usecase.GetArticleListUseCase
import com.gngsn.ditto.application.port.output.GetArticleListPort
import com.gngsn.ditto.domain.Article
import com.gngsn.ditto.support.UseCase
import org.springframework.data.domain.Page
import org.springframework.data.domain.Pageable

@UseCase
class GetArticleListService (
    val getArticleListPort: GetArticleListPort
) : GetArticleListUseCase {

    override fun execute(pageable: Pageable): Page<Article> {
        return getArticleListPort.findAll(pageable).map { // FIXME
            Article(
                it.title,
                it.content,
                it.author,
            )
        }
    }
}
