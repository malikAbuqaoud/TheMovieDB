package com.mag.themoviedb.app.home.service

sealed class Status {
    object Loading : Status()
    object Success : Status()
    object Error : Status()
}
