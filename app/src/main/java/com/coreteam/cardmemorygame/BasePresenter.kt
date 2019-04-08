package com.coreteam.cardmemorygame

interface BasePresenter<in T> {
    fun attachView(view: T)
}