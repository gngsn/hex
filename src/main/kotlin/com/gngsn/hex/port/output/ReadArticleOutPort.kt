package com.gngsn.hex.port.output

import com.gngsn.hex.domain.Article
import org.springframework.data.domain.Pageable

interface ReadArticleOutPort {
    fun findAll(pageable: Pageable): List<Article>
}
