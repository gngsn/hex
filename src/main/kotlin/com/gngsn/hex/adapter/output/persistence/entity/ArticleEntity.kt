package com.gngsn.hex.adapter.output.persistence.entity

import jakarta.persistence.*
import java.time.LocalDateTime

@Table(name = "article")
@Entity
class ArticleEntity (
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Int? = null,

    @Column(nullable = false)
    val title: String,
    @Column(nullable = false)
    val content: String,
    @Column(nullable = false)
    val author: String,
    @Column(nullable = false)
    val createAt: LocalDateTime,
    @Column(nullable = false)
    val modifiedAt: LocalDateTime
)