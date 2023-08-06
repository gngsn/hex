package com.gngsn.ditto.adapter.input.web

import com.gngsn.ditto.application.article.usecase.SaveArticleUseCase
import com.gngsn.ditto.domain.Article
import com.gngsn.ditto.support.WebAdapter
import jakarta.validation.Valid
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@WebAdapter
@RestController
@RequestMapping("/blog")
class ArticleController(
    val saveArticleUseCase: SaveArticleUseCase
) {

    @PostMapping("/article")
    fun post(@Valid @RequestBody article: Article): ResponseEntity<String>{
        saveArticleUseCase.execute(article)
        return ResponseEntity.ok("The request successes")
    }
}