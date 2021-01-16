package com.mag.themoviedb.app.home.presentation

import androidx.lifecycle.ViewModel
import androidx.lifecycle.liveData
import com.mag.themoviedb.app.home.data.HomeRepository
import com.mag.themoviedb.app.home.model.SortTypes
import com.mag.themoviedb.app.home.service.Resource
import kotlinx.coroutines.Dispatchers

class HomeViewModel : ViewModel() {

    private val repository = HomeRepository()

    fun getMoviesList(sort: SortTypes) =
        liveData(Dispatchers.IO) {
            emit(Resource.loading(data = null))
            try {
                emit(Resource.success(data = repository.getList(sort)))
            } catch (exception: Exception) {
                emit(
                    Resource.error(
                        data = null,
                        message = exception.message ?: "Something went wrong"
                    )
                )
            }
        }
}
