package com.coreteam.cardmemorygame.ui.main

class MainPresenter: MainContract.Presenter {

    lateinit var view: MainContract.View
    override fun attachView(view: MainContract.View) {
        this.view = view
    }


}