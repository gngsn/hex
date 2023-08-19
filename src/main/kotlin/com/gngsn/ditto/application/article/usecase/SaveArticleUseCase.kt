package com.gngsn.ditto.application.article.usecase;

import com.gngsn.ditto.domain.Article
import com.gngsn.ditto.port.output.SaveArticlePort
import com.gngsn.ditto.shared.support.UseCase
import jakarta.transaction.Transactional

@UseCase
class SaveArticleUseCase(
    val saveArticlePort: SaveArticlePort
) {

    @Transactional
    fun save(article: Article) {
        saveArticlePort.save(article)
    }
}
