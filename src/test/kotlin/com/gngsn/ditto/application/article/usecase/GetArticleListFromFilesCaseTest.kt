package com.gngsn.ditto.application.article.usecase

import com.gngsn.ditto.port.input.LocalFileReadPort
import io.mockk.MockKAnnotations
import io.mockk.impl.annotations.InjectMockKs
import io.mockk.impl.annotations.MockK
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test

class GetArticleListFromFilesCaseTest {

    @MockK
    lateinit var localFileReadPort: LocalFileReadPort

    @InjectMockKs
    lateinit var getArticleListFromFilesCase: GetArticleListFromFilesCase

    @BeforeEach
    fun setUp() = MockKAnnotations.init(this)

    @Test
    fun read_md_files() {
        getArticleListFromFilesCase.execute()
    }
}