package com.gngsn.ditto.adapter.external.persistence.repository

import com.gngsn.ditto.adapter.external.persistence.entity.ArticleEntity
import org.springframework.data.repository.CrudRepository
import org.springframework.stereotype.Repository

@Repository
interface ArticleMasterRepository : CrudRepository<ArticleEntity, Long>