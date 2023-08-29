package com.gngsn.hex.shared.configuration;

import org.springframework.cloud.openfeign.EnableFeignClients
import org.springframework.context.annotation.Configuration

@Configuration
@EnableFeignClients(basePackages = ["com.gngsn.hex"])
class FeignClientConfiguration