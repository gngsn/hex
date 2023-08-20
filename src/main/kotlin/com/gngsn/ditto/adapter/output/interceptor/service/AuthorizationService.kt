package com.gngsn.ditto.adapter.output.interceptor.service

interface AuthorizationService {
    fun getAuthToken(): String
}