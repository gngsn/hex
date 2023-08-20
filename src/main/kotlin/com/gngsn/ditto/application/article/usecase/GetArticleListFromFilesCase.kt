package com.gngsn.ditto.application.article.usecase;

import com.gngsn.ditto.domain.Article
import com.gngsn.ditto.port.input.LocalFileReadPort
import com.gngsn.ditto.shared.support.UseCase

@UseCase
class GetArticleListFromFilesCase(
    val localFileReadPort: LocalFileReadPort
) {

    fun execute(): List<Article> {
        return localFileReadPort.readAllFiles().map {
            Article("", it, "sunny")
        }
    }
}
