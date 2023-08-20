package com.gngsn.ditto.port.input

import org.springframework.http.ResponseEntity

interface MarkdownRoutePort {

    fun renderFile(): ResponseEntity<String>
}
