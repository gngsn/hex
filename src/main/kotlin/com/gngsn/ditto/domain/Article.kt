package com.gngsn.ditto.domain;

import com.gngsn.ditto.adapter.output.entity.ArticleEntity
import jakarta.validation.constraints.NotBlank
import java.time.LocalDateTime

/**
 * Article domain
 */
data class Article (
    @field:NotBlank(message = "'title' must not be blank!") val title: String,
    @field:NotBlank(message = "'content' must not be blank!")  val content: String,
    @field:NotBlank(message = "'author' must not be blank!")  val author: String,
) {
    fun toEntity(): ArticleEntity {
        return ArticleEntity(
            null,
            this.title,
            this.content,
            this.author,
            LocalDateTime.now(),
            LocalDateTime.now()
        );
    }
}