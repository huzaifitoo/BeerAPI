package com.example.beerapi.Network

import retrofit2.Call
import retrofit2.http.GET

interface APIInterface {

    @GET("beers")
fun getBeers(): Call<ResponseBeerModel>
}