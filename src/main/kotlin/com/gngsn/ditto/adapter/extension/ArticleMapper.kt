package com.gngsn.ditto.adapter.extension

import com.gngsn.ditto.adapter.output.persistence.entity.ArticleEntity
import com.gngsn.ditto.domain.Article
import java.time.LocalDateTime

fun ArticleEntity.toVO(): Article = Article(
    this.title,
    this.content,
    this.author,
)

fun Article.toEntity(): ArticleEntity = ArticleEntity(
    null,
    this.title,
    this.content,
    this.author,
    LocalDateTime.now(),
    LocalDateTime.now()
)
