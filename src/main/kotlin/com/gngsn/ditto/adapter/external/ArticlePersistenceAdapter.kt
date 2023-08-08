package com.gngsn.ditto.adapter.external;

import com.gngsn.ditto.adapter.external.persistence.entity.ArticleEntity
import com.gngsn.ditto.adapter.external.persistence.repository.ArticleMasterRepository
import com.gngsn.ditto.adapter.external.persistence.repository.ArticleSlaveRepository
import com.gngsn.ditto.application.port.output.GetArticleListPort
import com.gngsn.ditto.application.port.output.SaveArticlePort
import com.gngsn.ditto.domain.Article
import com.gngsn.ditto.support.Adapter
import org.springframework.data.domain.Page
import org.springframework.data.domain.Pageable

@Adapter
class ArticlePersistenceAdapter(
    private val articleMasterRepository: ArticleMasterRepository,
    private val articleSlaveRepository: ArticleSlaveRepository
): SaveArticlePort, GetArticleListPort {

    override fun save(article: Article) {
        articleMasterRepository.save(article.toEntity())
    }

    override fun findAll(pageable: Pageable): Page<ArticleEntity> {
        return articleSlaveRepository.findAll(pageable)
    }
}