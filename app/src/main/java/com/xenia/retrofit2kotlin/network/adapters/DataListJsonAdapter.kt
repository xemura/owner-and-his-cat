package com.xenia.retrofit2kotlin.network.adapters

import com.squareup.moshi.FromJson
import com.squareup.moshi.JsonQualifier
import com.squareup.moshi.ToJson
import com.xenia.retrofit2kotlin.model.Data
import com.xenia.retrofit2kotlin.model.User

@Retention(AnnotationRetention.RUNTIME)
@JsonQualifier
annotation class WrappedUserList

class DataListJsonAdapter {
    // @WrappedUserList annotation to unwrap the repository items
    // so that the return type of the Retrofit function is List<User>
    @WrappedUserList
    @FromJson
    fun fromJson(json: Data) : List<User> {
        return json.data
    }

    @ToJson
    fun toJson(@WrappedUserList value: List<User>): Data {
        throw UnsupportedOperationException()
    }
}