package com.gngsn.hex.port.input

import com.gngsn.hex.domain.Article

interface SaveArticleInputPort {

    fun post(article: Article)
}
