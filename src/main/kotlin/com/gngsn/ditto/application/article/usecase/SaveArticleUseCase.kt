package com.gngsn.ditto.application.article.usecase

import com.gngsn.ditto.domain.Article
import com.gngsn.ditto.port.input.SaveArticleInputPort
import com.gngsn.ditto.port.output.WriteArticleOutPort
import com.gngsn.ditto.shared.support.UseCase
import jakarta.transaction.Transactional

@UseCase
class SaveArticleUseCase(
    val writeArticleOutPort: WriteArticleOutPort
) : SaveArticleInputPort {

    @Transactional
    override fun post(article: Article) {
        writeArticleOutPort.save(article)
    }
}
