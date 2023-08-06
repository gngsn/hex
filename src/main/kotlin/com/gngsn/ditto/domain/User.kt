package com.gngsn.ditto.domain;

/**
 * User domain
 */
data class User (
    val nickname: String,
    val name: String,
    val email: String,
    val profile: Profile,
)