package com.mag.themoviedb.app.home.model

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class Movie(
    val adult: Boolean,
    val backdrop_path: String?,
    val genre_ids: List<Int> = emptyList(),
    val id: Int,
    val original_title: String,
    val original_language: String,
    val overview: String,
    val popularity: Double,
    val poster_path: String?,
    val release_date: String,
    val title: String,
    val video: Boolean,
    val vote_count: Int,
    val vote_average: Double
) : Parcelable
