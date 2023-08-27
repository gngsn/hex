package com.gngsn.hex.port.output

import com.gngsn.hex.domain.Article

interface WriteArticleOutPort {

    fun save(article: Article)
}
