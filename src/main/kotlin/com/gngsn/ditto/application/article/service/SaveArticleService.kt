package com.gngsn.ditto.application.article.service;

import com.gngsn.ditto.application.article.usecase.SaveArticleUseCase
import com.gngsn.ditto.application.port.output.SaveArticlePort
import com.gngsn.ditto.domain.Article
import com.gngsn.ditto.support.UseCase
import jakarta.transaction.Transactional

@UseCase
class SaveArticleService (
    val saveArticlePort: SaveArticlePort
) : SaveArticleUseCase {

    @Transactional
    override fun execute(article: Article) {
        saveArticlePort.save(article)
    }
}
