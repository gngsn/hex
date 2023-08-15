package com.gngsn.ditto.adapter.input.web

import com.gngsn.ditto.application.article.usecase.GetArticleUseCase
import com.gngsn.ditto.application.article.usecase.SaveArticleUseCase
import com.gngsn.ditto.domain.Article
import com.gngsn.ditto.shared.model.PagingCommand
import com.gngsn.ditto.support.WebAdapter
import jakarta.validation.Valid
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*

@WebAdapter
@RestController
@RequestMapping("/blog")
class ArticleController(
    val saveArticleUseCase: SaveArticleUseCase,
    val getArticleUseCase: GetArticleUseCase
) {

    @GetMapping
    fun get(pagingCommand: PagingCommand): ResponseEntity<List<Article>> {
        return ResponseEntity.ok(getArticleUseCase.getList(pagingCommand))
    }

    @PostMapping("article")
    fun post(@Valid @RequestBody article: Article): ResponseEntity<String>{
        saveArticleUseCase.save(article)
        return ResponseEntity.ok("The request successes")
    }
}