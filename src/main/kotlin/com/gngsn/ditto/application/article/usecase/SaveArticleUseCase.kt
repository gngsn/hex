package com.gngsn.ditto.application.article.usecase;

import com.gngsn.ditto.domain.Article

interface SaveArticleUseCase {
    fun save(article: Article)
}
