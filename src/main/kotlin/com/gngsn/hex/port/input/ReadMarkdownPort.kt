package com.gngsn.hex.port.input

import org.springframework.http.ResponseEntity

interface ReadMarkdownPort {

    fun renderFile(): ResponseEntity<String>
}
