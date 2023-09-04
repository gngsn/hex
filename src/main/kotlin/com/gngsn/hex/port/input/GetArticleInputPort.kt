package com.gngsn.hex.port.input

import com.gngsn.hex.domain.Article
import org.springframework.data.domain.Pageable

interface GetArticleInputPort {

    fun get(pageable: Pageable): List<Article>
}
