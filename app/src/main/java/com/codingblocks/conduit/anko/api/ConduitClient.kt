package com.codingblocks.conduit.anko.api

import okhttp3.*
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit

object ConduitClient {
    var jwt = ""

    private val httpClient = OkHttpClient.Builder()
        .callTimeout(2, TimeUnit.SECONDS)
        .addInterceptor { chain ->
            if (jwt.isNotEmpty()) {
                 chain.proceed(
                    chain.request().newBuilder().header(
                        "Authorization", "Token $jwt"
                    ).build()
                )
            } else {
                chain.proceed(chain.request())
            }
        }
        .build()

    private val retrofit = Retrofit.Builder()
        .addConverterFactory(GsonConverterFactory.create())
        .baseUrl("https://conduit.productionready.io/api/")
        .client(httpClient)
        .build()


    val api = retrofit.create(ConduitInterface::class.java)
}