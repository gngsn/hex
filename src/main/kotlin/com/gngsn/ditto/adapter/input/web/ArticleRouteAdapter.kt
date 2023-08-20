package com.gngsn.ditto.adapter.input.web

import com.gngsn.ditto.application.article.usecase.GetArticleListUseCase
import com.gngsn.ditto.application.article.usecase.SaveArticleUseCase
import com.gngsn.ditto.domain.Article
import com.gngsn.ditto.port.input.ArticleRoutePort
import com.gngsn.ditto.shared.model.PagingCommand
import com.gngsn.ditto.shared.support.Adapter
import jakarta.validation.Valid
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*

@Adapter
@RestController
@RequestMapping("/blog")
class ArticleRouteAdapter(
    val saveArticleUseCase: SaveArticleUseCase,
    val getArticleListUseCase: GetArticleListUseCase
): ArticleRoutePort {

    @GetMapping
    override fun get(pagingCommand: PagingCommand): ResponseEntity<List<Article>> {
        return ResponseEntity.ok(getArticleListUseCase.execute(pagingCommand))
    }

    @PostMapping("article")
    override fun post(@Valid @RequestBody article: Article): ResponseEntity<String> {
        saveArticleUseCase.execute(article)
        return ResponseEntity.ok("The request successes")
    }
}