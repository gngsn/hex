package com.gngsn.ditto.configuration;

import org.springframework.cloud.openfeign.EnableFeignClients;

@EnableFeignClients(basePackages = ["com.gngsn.ditto"])
class FeignClientConfiguration