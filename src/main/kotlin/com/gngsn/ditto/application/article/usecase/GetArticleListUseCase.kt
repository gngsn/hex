package com.gngsn.ditto.application.article.usecase

import com.gngsn.ditto.domain.Article
import org.springframework.data.domain.Page
import org.springframework.data.domain.Pageable

interface GetArticleListUseCase {
    fun getList(pageable: Pageable): Page<Article>
}
