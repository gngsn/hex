package com.gngsn.ditto.port.output

import com.gngsn.ditto.domain.Article

interface UpsertArticleOutPort {

    fun upsert(article: Article)
}
