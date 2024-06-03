package com.example.moviesearch.MoviesData

data class Result(
    val advisedMinimumAudienceAge: Int,
    val backdropPath: String,
    val backdropURLs: BackdropURLs,
    val cast: List<String>,
    val countries: List<String>,
    val directors: List<String>,
    val genres: List<Genre>,
    val imdbId: String,
    val imdbRating: Int,
    val imdbVoteCount: Int,
    val originalLanguage: String,
    val originalTitle: String,
    val overview: String,
    val posterPath: String,
    val posterURLs: PosterURLs,
    val runtime: Int,
    val streamingInfo: StreamingInfo,
    val tagline: String,
    val title: String,
    val tmdbId: Int,
    val tmdbRating: Int,
    val type: String,
    val year: Int,
    val youtubeTrailerVideoId: String,
    val youtubeTrailerVideoLink: String
)