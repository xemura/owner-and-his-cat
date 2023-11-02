package com.xenia.retrofit2kotlin.network.adapters

import com.squareup.moshi.FromJson
import com.squareup.moshi.ToJson
import com.xenia.retrofit2kotlin.model.Cat
import com.xenia.retrofit2kotlin.model.DataCat

class DataListJsonAdapterImagesOfCats {
    @FromJson
    fun fromJson(json: List<Cat>) : List<Cat> {
        return json
    }

    @ToJson
    fun toJson(@WrappedUserList value: List<Cat>): DataCat {
        throw UnsupportedOperationException()
    }
}