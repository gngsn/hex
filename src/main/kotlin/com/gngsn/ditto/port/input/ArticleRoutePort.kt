package com.gngsn.ditto.port.input

import com.gngsn.ditto.domain.Article
import com.gngsn.ditto.shared.model.PagingCommand
import org.springframework.http.ResponseEntity

interface ArticleRoutePort {

    fun get(pagingCommand: PagingCommand): ResponseEntity<List<Article>>

    fun post(article: Article): ResponseEntity<String>
}
