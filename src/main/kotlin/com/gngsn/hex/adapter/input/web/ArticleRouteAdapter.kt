package com.gngsn.hex.adapter.input.web

import com.gngsn.hex.application.article.usecase.GetArticleListUseCase
import com.gngsn.hex.application.article.usecase.SaveArticleUseCase
import com.gngsn.hex.domain.Article
import com.gngsn.hex.shared.model.PagingCommand
import com.gngsn.hex.shared.support.Adapter
import jakarta.validation.Valid
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*

@Adapter
@RestController
@RequestMapping("/blog")
class ArticleRouteAdapter(
    val saveArticleUseCase: SaveArticleUseCase,
    val getArticleListUseCase: GetArticleListUseCase
) {

    @GetMapping
    fun get(pagingCommand: PagingCommand): ResponseEntity<List<Article>> {
        return ResponseEntity.ok(getArticleListUseCase.get(pagingCommand))
    }

    @PostMapping("article")
    fun post(@Valid @RequestBody article: Article): ResponseEntity<String> {
        saveArticleUseCase.post(article)
        return ResponseEntity.ok("The request successes")
    }
}