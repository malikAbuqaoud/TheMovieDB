package com.mag.themoviedb.app.home.data

import com.mag.themoviedb.app.home.model.Category
import com.mag.themoviedb.app.home.model.SortTypes
import com.mag.themoviedb.app.home.service.HomeService
import com.mag.themoviedb.foundation.client.RetrofitFactory.apiClient

class HomeRepository {

    private val service = apiClient().create(HomeService::class.java)

    fun getList(sortBy: SortTypes): Category =
        service.getHomeList(
            key = "114fe6670282f6a632638661e5e86dee",
            sortBy = sortBy.value
        ).execute().body()!!
}
