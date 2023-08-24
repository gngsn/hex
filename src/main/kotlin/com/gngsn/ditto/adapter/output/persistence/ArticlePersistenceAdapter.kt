package com.gngsn.ditto.adapter.output.persistence

import com.gngsn.ditto.adapter.extension.toEntity
import com.gngsn.ditto.adapter.output.persistence.entity.ArticleEntity
import com.gngsn.ditto.adapter.output.persistence.repository.ArticleMasterRepository
import com.gngsn.ditto.adapter.output.persistence.repository.ArticleSlaveRepository
import com.gngsn.ditto.domain.Article
import com.gngsn.ditto.port.output.ReadArticleOutPort
import com.gngsn.ditto.port.output.WriteArticleOutPort
import com.gngsn.ditto.shared.model.PagingCommand
import com.gngsn.ditto.shared.support.Adapter

@Adapter
class ArticlePersistenceAdapter(
    private val articleMasterRepository: ArticleMasterRepository,
    private val articleSlaveRepository: ArticleSlaveRepository
) : ReadArticleOutPort, WriteArticleOutPort {

    override fun findAll(pagingCommand: PagingCommand): List<ArticleEntity> {
        return articleSlaveRepository.findAllByAuthorWithPaging(
            "",
            pagingCommand.page * pagingCommand.size,
            pagingCommand.size
        )
    }

    override fun save(article: Article) {
        articleMasterRepository.save(article.toEntity())
    }
}
