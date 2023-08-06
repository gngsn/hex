package com.gngsn.ditto.adapter.output.repository

import com.gngsn.ditto.adapter.output.entity.ArticleEntity
import org.springframework.data.repository.CrudRepository
import org.springframework.stereotype.Repository

@Repository
interface ArticleRepository : CrudRepository<ArticleEntity, Long>