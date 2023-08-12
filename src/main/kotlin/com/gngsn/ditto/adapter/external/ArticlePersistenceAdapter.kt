package com.gngsn.ditto.adapter.external;

import com.gngsn.ditto.adapter.external.persistence.entity.ArticleEntity
import com.gngsn.ditto.adapter.external.persistence.repository.ArticleMasterRepository
import com.gngsn.ditto.adapter.external.persistence.repository.ArticleSlaveRepository
import com.gngsn.ditto.application.port.output.GetArticleListPort
import com.gngsn.ditto.application.port.output.SaveArticlePort
import com.gngsn.ditto.domain.Article
import com.gngsn.ditto.shared.model.PagingCommand
import com.gngsn.ditto.support.Adapter

@Adapter
class ArticlePersistenceAdapter(
    private val articleMasterRepository: ArticleMasterRepository,
    private val articleSlaveRepository: ArticleSlaveRepository
): SaveArticlePort, GetArticleListPort {

    override fun save(article: Article) {
        articleMasterRepository.save(article.toEntity())
    }

    override fun findAll(pagingCommand: PagingCommand): List<ArticleEntity> {
        return articleSlaveRepository.findAllByAuthorWithPaging("",
            pagingCommand.page * pagingCommand.size,
            pagingCommand.size)
    }
}
