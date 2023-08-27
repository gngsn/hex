package com.gngsn.hex.adapter.output.api

import com.gngsn.hex.port.output.RenderToHtmlOutPort
import com.gngsn.hex.shared.support.Adapter
import org.springframework.cloud.openfeign.FeignClient
import org.springframework.web.bind.annotation.PostMapping


@Adapter
@FeignClient("github")
interface RenderToHtmlOutAdapter : RenderToHtmlOutPort {

    @PostMapping("/markdown")
    override fun render(body: RenderToHtmlOutPort.RenderRequestBody): String
}
