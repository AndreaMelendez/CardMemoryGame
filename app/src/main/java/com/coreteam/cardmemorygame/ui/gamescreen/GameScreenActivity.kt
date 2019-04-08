package com.coreteam.cardmemorygame.ui.gamescreen

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.coreteam.cardmemorygame.R
import com.coreteam.cardmemorygame.util.EASYLEVEL
import com.coreteam.cardmemorygame.util.EASYLEVELINT
import kotlin.random.Random

class GameScreenActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_game_screen)

        val level = intent.getIntExtra(EASYLEVEL, 0)
        if (level != 0) {
            when (level) {
                EASYLEVELINT -> setContentView(R.layout.easy_level_screen)
            }
        }

        loadImagesToButtons()
    }

    fun loadImagesToButtons() {
        // TODO validate the level we are working on
        val loop = 9
        var array = mutableListOf( 1, 2, 3, 4, 5, 6, 7, 8, 9)
        var images = hashMapOf(R.drawable.ic_twotone_insert_emoticon_24px to 0,
            R.drawable.ic_twotone_move_to_inbox_24px to 0,
            R.drawable.ic_twotone_send_24px to 0)

       while(array.size != 0){
           var random: Int = 0
            if (array.size == 1) {
                random = 1
            } else
                random = Random.nextInt(1, array.size)

            Log.i("TAG", random.toString())
            array.removeAt(random -1)
        }

    }
}
