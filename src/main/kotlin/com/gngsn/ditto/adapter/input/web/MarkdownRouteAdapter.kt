package com.gngsn.ditto.adapter.input.web

import com.gngsn.ditto.application.markdown.GetRenderedMarkdownUseCase
import com.gngsn.ditto.port.input.MarkdownRoutePort
import com.gngsn.ditto.shared.support.Adapter
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*

@Adapter
@RestController
@RequestMapping("/markdown")
class MarkdownRouteAdapter(
    val getRenderedMarkdownUseCase: GetRenderedMarkdownUseCase,
): MarkdownRoutePort {

    @GetMapping
    override fun renderFile(): ResponseEntity<String> {
        return ResponseEntity.ok(getRenderedMarkdownUseCase.render())
    }
}