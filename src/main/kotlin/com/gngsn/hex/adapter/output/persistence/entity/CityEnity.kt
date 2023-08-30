package com.gngsn.hex.adapter.output.persistence.entity

import jakarta.persistence.*

@Entity
@Table(name = "cities")
class CityEnity (
    @Id @GeneratedValue(strategy = GenerationType.AUTO) private val id: Long,
    private val name: String,
    private val population: Int
)