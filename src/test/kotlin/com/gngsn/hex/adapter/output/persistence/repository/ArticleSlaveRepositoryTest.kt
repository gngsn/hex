package com.gngsn.hex.adapter.output.persistence.repository

import org.junit.jupiter.api.Test
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest

@SpringBootTest
class ArticleSlaveRepositoryTest(
    @Autowired private val articleSlaveRepository: ArticleSlaveRepository
) {
    @Test
    fun run() {
        articleSlaveRepository.find("sunny")
    }
}

