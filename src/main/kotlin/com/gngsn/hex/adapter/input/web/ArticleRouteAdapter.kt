package com.gngsn.hex.adapter.input.web

import com.gngsn.hex.domain.Article
import com.gngsn.hex.port.input.GetArticleInputPort
import com.gngsn.hex.port.input.SaveArticleInputPort
import com.gngsn.hex.shared.support.Adapter
import jakarta.validation.Valid
import org.springframework.data.domain.Pageable
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*

@Adapter
@RestController
@RequestMapping("/blog")
class ArticleRouteAdapter(
    val getArticleInputPort: GetArticleInputPort,
    val saveArticleInputPort: SaveArticleInputPort
) {

    @GetMapping
    fun get(author: String, pageable: Pageable): ResponseEntity<List<Article>> {
        return ResponseEntity.ok(getArticleInputPort.get(author, pageable))
    }

    @PostMapping("article")
    fun post(@Valid @RequestBody article: Article): ResponseEntity<String> {
        saveArticleInputPort.post(article)
        return ResponseEntity.ok("The request successes")
    }
}