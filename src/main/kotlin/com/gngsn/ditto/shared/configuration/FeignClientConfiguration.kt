package com.gngsn.ditto.shared.configuration;

import org.springframework.cloud.openfeign.EnableFeignClients
import org.springframework.context.annotation.Configuration

@Configuration
@EnableFeignClients(basePackages = ["com.gngsn.ditto"])
class FeignClientConfiguration