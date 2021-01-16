package com.mag.themoviedb.app.home.service

data class Resource<out T>(val status: Status, val data: T?, val message: String? = null) {

    companion object {

        fun <T> loading(data: T?): Resource<T> =
            Resource(status = Status.Loading, data = data)

        fun <T> success(data: T): Resource<T> =
            Resource(status = Status.Success, data = data)

        fun <T> error(data: T?, message: String?): Resource<T> =
            Resource(status = Status.Error, data = data, message = message)
    }
}
