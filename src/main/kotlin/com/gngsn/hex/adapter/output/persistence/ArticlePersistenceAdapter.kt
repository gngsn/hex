package com.gngsn.hex.adapter.output.persistence

import com.gngsn.hex.adapter.extension.toEntity
import com.gngsn.hex.adapter.output.persistence.entity.ArticleEntity
import com.gngsn.hex.adapter.output.persistence.repository.ArticleMasterRepository
import com.gngsn.hex.adapter.output.persistence.repository.ArticleSlaveRepository
import com.gngsn.hex.domain.Article
import com.gngsn.hex.port.output.ReadArticleOutPort
import com.gngsn.hex.port.output.UpsertArticleOutPort
import com.gngsn.hex.port.output.WriteArticleOutPort
import com.gngsn.hex.shared.model.PagingCommand
import com.gngsn.hex.shared.support.Adapter

@Adapter
class ArticlePersistenceAdapter(
    private val articleMasterRepository: ArticleMasterRepository,
    private val articleSlaveRepository: ArticleSlaveRepository
) : ReadArticleOutPort, WriteArticleOutPort, UpsertArticleOutPort {

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

    override fun upsert(article: Article) {
        articleMasterRepository.save(article.toEntity())
    }
}
