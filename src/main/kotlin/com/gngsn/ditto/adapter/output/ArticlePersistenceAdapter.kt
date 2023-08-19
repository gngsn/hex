package com.gngsn.ditto.adapter.output;

import com.gngsn.ditto.adapter.output.persistence.entity.ArticleEntity
import com.gngsn.ditto.adapter.output.persistence.repository.ArticleMasterRepository
import com.gngsn.ditto.adapter.output.persistence.repository.ArticleSlaveRepository
import com.gngsn.ditto.domain.Article
import com.gngsn.ditto.port.output.GetArticleListPort
import com.gngsn.ditto.port.output.SaveArticlePort
import com.gngsn.ditto.shared.model.PagingCommand
import com.gngsn.ditto.shared.support.Adapter

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
