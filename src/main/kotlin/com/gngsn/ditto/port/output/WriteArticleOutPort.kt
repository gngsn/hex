package com.gngsn.ditto.port.output

import com.gngsn.ditto.domain.Article

interface WriteArticleOutPort {

    fun save(article: Article)
}
