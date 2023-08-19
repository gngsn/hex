package com.gngsn.ditto.port.output;

import com.gngsn.ditto.domain.Article

interface SaveArticlePort {
    fun save(article: Article)
}
