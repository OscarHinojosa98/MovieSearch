package com.example.moviesearch

import com.example.moviesearch.MoviesData.Movies
import com.example.moviesearch.MoviesData.Result
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Headers
import retrofit2.http.Query

interface MovieService {

    @Headers("content-type:" + "application/octet-stream", "X-RapidAPI-Key:" + "7a3c7f6ae9msh8d8abb68de23261p1f3bc5jsn864e4d11ff31",
        "X-RapidAPI-Host:" + "streaming-availability.p.rapidapi.com")
    @GET("/v2/search/title")
    suspend fun getSearchResults(@Query(value = "title") title:String,
                                @Query(value = "country") country:String,
                                @Query(value = "show_type") show_type:String,
                                @Query(value = "output_language") output_language:String): Response<Movies>
}

