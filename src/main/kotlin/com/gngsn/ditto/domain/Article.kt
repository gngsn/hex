package com.gngsn.ditto.domain

import jakarta.validation.constraints.NotBlank

/**
 * Article domain
 */
data class Article(
    @field:NotBlank(message = "'title' must not be blank!") val title: String,
    @field:NotBlank(message = "'content' must not be blank!") val content: String,
    @field:NotBlank(message = "'author' must not be blank!") val author: String,
)