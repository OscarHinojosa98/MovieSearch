package com.example.moviesearch.MoviesData

data class Hbo(
    val addOn: String,
    val audios: List<Audio>,
    val leaving: Long,
    val link: String,
    val price: Any,
    val quality: String,
    val subtitles: List<SubtitleX>,
    val type: String,
    val watchLink: String
)