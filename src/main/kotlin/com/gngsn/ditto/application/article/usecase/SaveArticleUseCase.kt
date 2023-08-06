package com.gngsn.ditto.application.article.usecase;

import com.gngsn.ditto.domain.Article
import com.gngsn.ditto.support.UseCase

@UseCase
interface SaveArticleUseCase {
    fun execute(article: Article)
}
