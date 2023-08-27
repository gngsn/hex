package com.gngsn.hex.adapter.output.interceptor.service

import org.springframework.beans.factory.annotation.Value
import org.springframework.stereotype.Service

@Service
class ApiAuthorizationService(
    @Value("\${github.api.token}") private val githubApiToken: String
): AuthorizationService {

    override fun getAuthToken(): String {
        require(githubApiToken.isNotBlank())
        return "Bearer $githubApiToken"
    }
}
