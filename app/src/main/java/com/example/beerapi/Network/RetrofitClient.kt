package com.example.beerapi.Network

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class RetrofitClient {
    private lateinit var retrofit: Retrofit

    fun getClient(): Retrofit {
        retrofit = Retrofit
            .Builder()
            .baseUrl("https://api.punkapi.com/v2/")
            .addConverterFactory(GsonConverterFactory.create())
            .build()

        return retrofit
    }
}