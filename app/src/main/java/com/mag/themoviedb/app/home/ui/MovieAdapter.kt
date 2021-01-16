package com.mag.themoviedb.app.home.ui

import android.view.View
import android.widget.ImageView
import com.mag.themoviedb.R
import com.mag.themoviedb.app.details.MovieDetailsActivity
import com.mag.themoviedb.foundation.base.BaseAdapter
import com.mag.themoviedb.foundation.base.BaseViewHolder
import com.mag.themoviedb.foundation.common.loadImage
import com.mag.themoviedb.app.home.model.Movie

class MovieAdapter(list: List<Movie>) : BaseAdapter<Movie>(list) {

    override fun getViewHolder(view: View, viewType: Int): BaseViewHolder<Movie> =
        MovieAdapterVH(view)

    override fun layoutId(viewType: Int): Int = R.layout.adapter_movie

    class MovieAdapterVH(itemView: View) : BaseViewHolder<Movie>(itemView) {

        private val movieImage: ImageView = itemView.findViewById(R.id.movieImage)

        override fun bind(item: Movie) {
            movieImage.loadImage(item.poster_path.orEmpty())
            itemView.setOnClickListener { MovieDetailsActivity.start(this.itemView.context, item) }
        }
    }
}
