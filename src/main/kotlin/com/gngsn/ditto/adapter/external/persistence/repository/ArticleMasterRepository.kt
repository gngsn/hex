package com.gngsn.ditto.adapter.external.persistence.repository

import com.gngsn.ditto.adapter.external.persistence.entity.ArticleEntity
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface ArticleMasterRepository : JpaRepository<ArticleEntity, Long>