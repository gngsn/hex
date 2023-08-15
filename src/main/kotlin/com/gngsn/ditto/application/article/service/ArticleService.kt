package com.gngsn.ditto.application.article.service;

import com.gngsn.ditto.application.article.mapper.toVO
import com.gngsn.ditto.application.article.usecase.GetArticleUseCase
import com.gngsn.ditto.application.article.usecase.SaveArticleUseCase
import com.gngsn.ditto.application.port.output.GetArticleListPort
import com.gngsn.ditto.application.port.output.SaveArticlePort
import com.gngsn.ditto.domain.Article
import com.gngsn.ditto.shared.model.PagingCommand
import com.gngsn.ditto.support.UseCase
import jakarta.transaction.Transactional

@UseCase
class ArticleService (
    val getArticleListPort: GetArticleListPort,
    val saveArticlePort: SaveArticlePort
) : GetArticleUseCase, SaveArticleUseCase {

    override fun getList(pagingCommand: PagingCommand): List<Article> {
        return getArticleListPort.findAll(pagingCommand).map { it.toVO() }
    }

    @Transactional
    override fun save(article: Article) {
        saveArticlePort.save(article)
    }
}
