package com.gngsn.ditto.adapter.output.api

import com.gngsn.ditto.port.output.GithubFeignClientPort
import com.gngsn.ditto.shared.support.Adapter
import org.springframework.cloud.openfeign.FeignClient
import org.springframework.web.bind.annotation.PostMapping


@Adapter
@FeignClient("github")
interface GithubFeignClientAdapter: GithubFeignClientPort {

    @PostMapping("/markdown")
    override fun renderMarkdown(body: GithubFeignClientPort.RenderRequestBody): String
}
