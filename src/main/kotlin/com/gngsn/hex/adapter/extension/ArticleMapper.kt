package com.gngsn.hex.adapter.extension

import com.gngsn.hex.adapter.output.persistence.entity.ArticleEntity
import com.gngsn.hex.domain.Article
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
