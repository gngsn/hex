package com.gngsn.ditto.application.article.service;

import com.gngsn.ditto.application.article.usecase.GetArticleUseCase
import com.gngsn.ditto.application.article.usecase.SaveArticleUseCase
import com.gngsn.ditto.application.port.output.GetArticleListPort
import com.gngsn.ditto.application.port.output.SaveArticlePort
import com.gngsn.ditto.domain.Article
import com.gngsn.ditto.support.UseCase
import jakarta.transaction.Transactional
import org.springframework.data.domain.Page
import org.springframework.data.domain.Pageable

@UseCase
class ArticleService (
    val getArticleListPort: GetArticleListPort,
    val saveArticlePort: SaveArticlePort
) : GetArticleUseCase, SaveArticleUseCase {

    override fun getList(pageable: Pageable): Page<Article> {
        return getArticleListPort.findAll(pageable).map { // FIXME
            Article(
                it.title,
                it.content,
                it.author,
            )
        }
    }

    @Transactional
    override fun save(article: Article) {
        saveArticlePort.save(article)
    }
}
