package com.xenia.retrofit2kotlin.network.interfaces

import com.squareup.moshi.Moshi
import com.xenia.retrofit2kotlin.model.User
import com.xenia.retrofit2kotlin.network.adapters.DataListJsonAdapter
import com.xenia.retrofit2kotlin.network.adapters.WrappedUserList
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory
import retrofit2.http.GET

private const val BASE_URL =
    "https://fakerapi.it/api/v1/"

//Build the Moshi object with Kotlin adapter factory that Retrofit will be using.
private val moshi = Moshi.Builder()
    .add(DataListJsonAdapter())
    .build()

// The Retrofit object with the Moshi converter.
private val retrofit = Retrofit.Builder()
    .baseUrl(BASE_URL)
    .addConverterFactory(MoshiConverterFactory.create(moshi))
    .build()

interface UserApiService {
    // @WrappedUserList annotation to unwrap the repository items
    // so that the return type of the Retrofit function is List<User>
    @GET("users")
    @WrappedUserList
    suspend fun getOwners(): List<User>
}

// A public Api object that exposes the lazy-initialized Retrofit service
object UserApi {
    val retrofitService: UserApiService by lazy { retrofit.create(UserApiService::class.java) }
}