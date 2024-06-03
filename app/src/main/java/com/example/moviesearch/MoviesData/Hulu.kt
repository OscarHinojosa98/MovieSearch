package com.example.moviesearch.MoviesData

import com.example.moviesearch.MoviesData.Audio

data class Hulu(
    val addOn: String,
    val audios: List<Audio>,
    val leaving: Int,
    val link: String,
    val price: Any,
    val quality: String,
    val type: String,
    val watchLink: String
)