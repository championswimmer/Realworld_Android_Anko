package com.codingblocks.conduit.anko.api

import com.codingblocks.conduit.anko.api.models.ArticlesResponse
import retrofit2.Call
import retrofit2.http.GET

interface ConduitInterface {

    @GET("articles")
    fun fetchArticles(): Call<ArticlesResponse>

}