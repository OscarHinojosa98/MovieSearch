package com.example.moviesearch.MoviesData

import com.example.moviesearch.MoviesData.Apple
import com.example.moviesearch.MoviesData.Hbo
import com.example.moviesearch.MoviesData.Hulu
import com.example.moviesearch.MoviesData.Netflix

data class Us(
    val apple: List<Apple>,
    val hbo: List<Hbo>,
    val hulu: List<Hulu>,
    val netflix: List<Netflix>?,
    val disney: List<Disney>?,
    val prime: List<Prime>?,
)