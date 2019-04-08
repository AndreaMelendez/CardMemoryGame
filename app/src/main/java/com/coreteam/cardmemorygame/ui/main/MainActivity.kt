package com.coreteam.cardmemorygame.ui.main

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.coreteam.cardmemorygame.R
import com.coreteam.cardmemorygame.ui.gamescreen.GameScreenActivity
import com.coreteam.cardmemorygame.util.EASYLEVEL
import com.coreteam.cardmemorygame.util.EASYLEVELINT
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity(), MainContract.View {

    lateinit var presenter: MainContract.Presenter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        presenter = MainPresenter()
        presenter.attachView(this)

        easyLevel.setOnClickListener {
            val intent = Intent(this, GameScreenActivity::class.java)
            intent.putExtra(EASYLEVEL, EASYLEVELINT)

            startActivity(intent)
        }
    }



}
