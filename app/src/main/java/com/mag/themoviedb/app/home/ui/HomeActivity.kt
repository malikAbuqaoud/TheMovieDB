package com.mag.themoviedb.app.home.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.viewModels
import androidx.recyclerview.widget.RecyclerView
import com.mag.themoviedb.app.home.model.SortTypes
import com.mag.themoviedb.app.home.presentation.HomeViewModel
import com.mag.themoviedb.app.home.service.Status
import com.mag.themoviedb.databinding.ActivityMainBinding
import com.mag.themoviedb.foundation.ui.showLoadingFragment

class HomeActivity : AppCompatActivity() {

    lateinit var mainBinding: ActivityMainBinding

    private val viewModel: HomeViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        mainBinding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(mainBinding.root)
        setupObserver(SortTypes.POPULARITY_DESC, mainBinding.popularRecyclerView)
        setupObserver(SortTypes.VOTE_COUNT_DESC, mainBinding.topRatedRecyclerView)
        setupObserver(SortTypes.REVENUE_DESC, mainBinding.revenueRecyclerView)
    }

    private fun setupObserver(sortType: SortTypes, recyclerView: RecyclerView) {
        viewModel.getMoviesList(sortType).observe(this, {
            it?.let { resource ->
                when (resource.status) {
                    Status.Loading -> showLoading(true)
                    Status.Error -> showLoading()
                    Status.Success -> {
                        showLoading()
                        resource.data?.let { movies ->
                            recyclerView.adapter = MovieAdapter(movies.results)
                        }
                    }
                }
            }
        })
    }

    private fun showLoading(show: Boolean = false) {
        when (show) {
            true -> supportFragmentManager.showLoadingFragment()
            false -> supportFragmentManager.showLoadingFragment()?.dismiss()
        }
    }
}
