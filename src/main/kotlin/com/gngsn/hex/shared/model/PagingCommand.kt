package com.gngsn.hex.shared.model

data class PagingCommand(
    val page: Long = 0,
    val size: Long = 10
)
