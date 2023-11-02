package com.xenia.retrofit2kotlin.network.interfaces

import com.squareup.moshi.Moshi
import com.xenia.retrofit2kotlin.model.Cat
import com.xenia.retrofit2kotlin.network.adapters.DataListJsonAdapterImagesOfCats
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory
import retrofit2.http.GET

private const val BASE_URL_CATS =
    "https://api.thecatapi.com/v1/"

private val moshiCats = Moshi.Builder()
    .add(DataListJsonAdapterImagesOfCats())
    .build()

private val retrofitCats = Retrofit.Builder()
    .baseUrl(BASE_URL_CATS)
    .addConverterFactory(MoshiConverterFactory.create(moshiCats))
    .build()

interface CatApiService {

    @GET("images/search?limit=10")
    suspend fun getCats(): List<Cat>
}

object CatApi {
    val retrofitServiceCats: CatApiService by lazy { retrofitCats.create(CatApiService::class.java) }
}