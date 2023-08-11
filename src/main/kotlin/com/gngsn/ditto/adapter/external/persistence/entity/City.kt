package com.gngsn.ditto.adapter.external.persistence.entity

import jakarta.persistence.*

@Entity
@Table(name = "cities")
class City (
    @Id @GeneratedValue(strategy = GenerationType.AUTO) private val id: Long,
    private val name: String,
    private val population: Int
)