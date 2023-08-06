package com.gngsn.ditto.adapter.output;

import com.gngsn.ditto.adapter.output.repository.ArticleRepository
import com.gngsn.ditto.application.port.output.SaveArticlePort
import com.gngsn.ditto.domain.Article
import com.gngsn.ditto.support.Adapter

@Adapter
class ArticlePersistenceAdapter(
    private val articleRepository: ArticleRepository
): SaveArticlePort {

    override fun save(article: Article) {
        articleRepository.save(article.toEntity())
    }
}
