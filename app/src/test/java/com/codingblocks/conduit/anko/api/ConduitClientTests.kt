package com.codingblocks.conduit.anko.api

import org.junit.Test
import org.junit.Assert.*

class ConduitClientTests {


    @Test
    fun `GET api-articles works`() {
        val response = ConduitClient.api.fetchArticles().execute()

        response.body()?.let {
            assertEquals(500, it.articlesCount)
        } ?: throw Error("Response has no body")
    }
}