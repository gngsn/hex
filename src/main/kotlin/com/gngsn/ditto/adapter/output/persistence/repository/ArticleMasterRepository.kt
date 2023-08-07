package com.gngsn.ditto.adapter.output.persistence.repository

import com.gngsn.ditto.adapter.output.persistence.entity.ArticleEntity
import org.springframework.data.repository.CrudRepository
import org.springframework.stereotype.Repository

@Repository
interface ArticleMasterRepository : CrudRepository<ArticleEntity, Long>