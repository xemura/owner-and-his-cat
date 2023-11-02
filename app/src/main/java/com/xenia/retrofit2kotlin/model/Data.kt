package com.xenia.retrofit2kotlin.model
import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class Data(
    val status: String,
    val code: Int,
    val total: Int,
    val data: List<User>
)

@JsonClass(generateAdapter = true)
data class DataCat(
    val data: List<Cat>
)

@JsonClass(generateAdapter = true)
data class User (
    @Json(name = "id") val id: String,
    @Json(name = "uuid")  val uuid: String,
    @Json(name = "firstname")  val firstName: String,
    @Json(name = "lastname")  val lastName: String,
    @Json(name = "username")  val userName: String,
    @Json(name = "password")  val password: String,
    @Json(name = "email")  val email: String,
    @Json(name = "ip")  val ip: String,
    @Json(name = "macAddress")  val macAddress: String,
    @Json(name = "website")  val website: String,
    @Json(name = "image")  val image: String,
)

@JsonClass(generateAdapter = true)
data class Cat (
    @Json(name = "id") val id: String,
    @Json(name = "url")  val url: String,
    @Json(name = "width")  val width: String,
    @Json(name = "height")  val height: String,
)

