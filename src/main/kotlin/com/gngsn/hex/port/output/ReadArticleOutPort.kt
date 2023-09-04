package com.gngsn.hex.port.output

import com.gngsn.hex.adapter.output.persistence.entity.ArticleEntity
import org.springframework.data.domain.Pageable

interface ReadArticleOutPort {
    fun findAll(pageable: Pageable): List<ArticleEntity>
}
