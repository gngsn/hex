package com.gngsn.hex.domain

import jakarta.validation.constraints.NotBlank

/**
 * Article domain
 */
data class Article(
    val title: String,
    val content: String,
    val author: String,
) {
}