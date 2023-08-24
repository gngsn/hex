package com.gngsn.ditto.port.input

import org.springframework.http.ResponseEntity

interface ReadMarkdownPort {

    fun renderFile(): ResponseEntity<String>
}
