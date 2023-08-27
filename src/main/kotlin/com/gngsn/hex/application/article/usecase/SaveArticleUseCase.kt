package com.gngsn.hex.application.article.usecase

import com.gngsn.hex.domain.Article
import com.gngsn.hex.port.input.SaveArticleInputPort
import com.gngsn.hex.port.output.WriteArticleOutPort
import com.gngsn.hex.shared.support.UseCase
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
