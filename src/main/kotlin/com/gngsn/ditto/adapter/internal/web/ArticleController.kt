package com.gngsn.ditto.adapter.internal.web

import com.gngsn.ditto.application.article.usecase.GetArticleListUseCase
import com.gngsn.ditto.application.article.usecase.SaveArticleUseCase
import com.gngsn.ditto.domain.Article
import com.gngsn.ditto.support.WebAdapter
import jakarta.validation.Valid
import org.springframework.data.domain.Page
import org.springframework.data.domain.Pageable
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*

@WebAdapter
@RestController
@RequestMapping("/blog")
class ArticleController(
    val saveArticleUseCase: SaveArticleUseCase,
    val getArticleListUseCase: GetArticleListUseCase
) {

    @GetMapping
    fun get(@RequestParam pageable: Pageable): ResponseEntity<Page<Article>> {
        return ResponseEntity.ok(getArticleListUseCase.getList(pageable))
    }

    @PostMapping("/article")
    fun post(@Valid @RequestBody article: Article): ResponseEntity<String>{
        saveArticleUseCase.save(article)
        return ResponseEntity.ok("The request successes")
    }
}