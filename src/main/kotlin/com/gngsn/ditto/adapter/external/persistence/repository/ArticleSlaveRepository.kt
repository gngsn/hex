package com.gngsn.ditto.adapter.external.persistence.repository

import com.gngsn.ditto.adapter.external.persistence.entity.ArticleEntity
import org.springframework.data.repository.PagingAndSortingRepository

interface ArticleSlaveRepository : PagingAndSortingRepository<ArticleEntity, Long>