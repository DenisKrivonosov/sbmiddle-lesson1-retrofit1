package ru.skillbranch.retrofit1

import java.util.List
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query
//import ru.mustakimov.retrofittutorial.PostModel

interface UmoriliApi {
    @GET("search")
    fun getData(
        @Query("country") country: String
//        @Query("num") count: Int
    ): Call<List<PostModel>>
}