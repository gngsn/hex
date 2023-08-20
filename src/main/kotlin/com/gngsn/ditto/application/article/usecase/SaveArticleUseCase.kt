package com.gngsn.ditto.application.article.usecase;

import com.gngsn.ditto.domain.Article
import com.gngsn.ditto.port.output.ArticlePersistencePort
import com.gngsn.ditto.shared.support.UseCase
import jakarta.transaction.Transactional

@UseCase
class SaveArticleUseCase(
    val articlePersistencePort: ArticlePersistencePort
) {

    @Transactional
    fun execute(article: Article) {
        articlePersistencePort.save(article)
    }
}
