package com.example.moviesearch.MoviesData

data class ChosenMovie(
    val originalTitle: String,
    val overview: String,
    val posterPath: String,
    val posterURLs: PosterURLs,
    val streamingInfo: StreamingInfo,
    val title: String,
    val year: Int,
)
