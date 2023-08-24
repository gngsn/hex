package com.gngsn.ditto.port.input

import com.gngsn.ditto.domain.Article

interface SaveArticleInputPort {

    fun post(article: Article)
}
