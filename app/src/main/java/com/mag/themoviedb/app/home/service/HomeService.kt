package com.mag.themoviedb.app.home.service

import com.mag.themoviedb.app.home.model.Category
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

private const val DISCOVER_MOVES = "/3/discover/movie"
private const val API_KEY = "api_key"
private const val SORT_BY = "sort_by"

interface HomeService {

    @GET(DISCOVER_MOVES)
    fun getHomeList(
        @Query(API_KEY) key: String,
        @Query(SORT_BY) sortBy: String
    ): Call<Category>
}
