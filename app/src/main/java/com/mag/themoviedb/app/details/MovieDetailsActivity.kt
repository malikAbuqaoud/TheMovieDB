package com.mag.themoviedb.app.details

import android.content.Context
import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.mag.themoviedb.app.home.model.Movie
import com.mag.themoviedb.databinding.ActivityMovieDetailsBinding
import com.mag.themoviedb.foundation.common.ImageType
import com.mag.themoviedb.foundation.common.loadImage

private const val MOVIE_EXTRA_KEY = "movie_extra_key"

class MovieDetailsActivity : AppCompatActivity() {

    lateinit var mainBinding: ActivityMovieDetailsBinding

    companion object {
        fun start(context: Context, movie: Movie) = context.startActivity(
            Intent(context, MovieDetailsActivity::class.java).putExtra(
                MOVIE_EXTRA_KEY,
                movie
            )
        )
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        mainBinding = ActivityMovieDetailsBinding.inflate(layoutInflater)
        setContentView(mainBinding.root)
        setupMovieData()
    }

    private fun setupMovieData() {
        intent.extras?.getParcelable<Movie>(MOVIE_EXTRA_KEY)?.let { movie ->
            mainBinding.movieTitle.text = movie.title
            mainBinding.movieSubTitle.text = movie.overview
            val voteRang = (movie.vote_average / 2).toFloat() // voting of 5 instead out of 10
            mainBinding.ratingBar.rating = voteRang
            mainBinding.movieBannerImageView.loadImage(
                movie.backdrop_path.orEmpty(),
                ImageType.W500
            )
        }
    }
}