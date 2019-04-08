package com.coreteam.cardmemorygame.ui.main

import com.coreteam.cardmemorygame.BasePresenter
import com.coreteam.cardmemorygame.BaseView

interface MainContract {

    interface View: BaseView {
    }

    interface Presenter: BasePresenter<View> {

    }

}