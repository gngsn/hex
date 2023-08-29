package com.gngsn.hex.adapter.output.api

import com.gngsn.hex.port.output.RenderToHtmlOutPort
import com.gngsn.hex.shared.support.Adapter
import org.springframework.cloud.openfeign.FeignClient
import org.springframework.web.bind.annotation.PostMapping

@FeignClient("github")
interface RenderToHtmlClient {

    @PostMapping("/markdown")
    fun render(body: RenderToHtmlOutPort.RenderRequestBody): String
}
