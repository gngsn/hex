package com.gngsn.ditto.adapter.output.interceptor

import com.gngsn.ditto.adapter.output.interceptor.service.AuthorizationService
import feign.RequestInterceptor
import feign.RequestTemplate
import org.slf4j.Logger
import org.slf4j.LoggerFactory
import org.springframework.stereotype.Component

@Component
class GithubRequestHeaderInterceptor(
    private val authTokenService: AuthorizationService
) : RequestInterceptor {
    private val logger: Logger = LoggerFactory.getLogger(GithubRequestHeaderInterceptor::class.java)

    override fun apply(template: RequestTemplate) {
        template.header("Authorization", authTokenService.getAuthToken())
        template.header("Accept", "application/vnd.github+json")
        template.header("X-GitHub-Api-Version", "2022-11-28")

        logger.info("Github Request Header Interceptor - Setting a Request Header.\nHeader={$template}}")
    }
}