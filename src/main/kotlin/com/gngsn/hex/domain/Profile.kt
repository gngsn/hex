package com.gngsn.hex.domain;

/**
 * Profile domain
 */
data class Profile (
    val image: String,
    val bio: String,
    val follower: String,
    val following: String,
    val location: String,
)