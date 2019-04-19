package com.coreteam.cardmemorygame.ui.gamescreen

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Toast
import com.coreteam.cardmemorygame.R
import com.coreteam.cardmemorygame.util.EASYLEVEL
import com.coreteam.cardmemorygame.util.EASYLEVELINT
import kotlinx.android.synthetic.main.easy_level_screen.*
import kotlin.random.Random

class GameScreenActivity : AppCompatActivity(), View.OnClickListener {

    var imagesOriginal = mapOf("image0" to R.drawable.ic_twotone_insert_emoticon_24px,
        "image1" to R.drawable.ic_twotone_move_to_inbox_24px,
        "image2" to R.drawable.ic_twotone_send_24px,
        "image3" to R.drawable.ic_baseline_android_24px,
        "image4" to R.drawable.ic_twotone_audiotrack_24px,
        "image5" to R.drawable.ic_twotone_favorite_24px)
    val results = mutableMapOf<Int, String>()

    var actualCard: Int? = null


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

    override fun onClick(v: View?) {
        when (v) {
            btn1 ->  {
                assignImageToBotton(1, btn1)
            }
            btn2 -> {
                assignImageToBotton(2, btn2)
            }
            btn3 -> {
                assignImageToBotton(3, btn3)
            }
            btn4 -> {
                assignImageToBotton(4, btn4)
            }
            btn5 -> {
                assignImageToBotton(5, btn5)
            }
            btn6 -> {
                assignImageToBotton(6, btn6)
            }
            btn7 -> {
                assignImageToBotton(7, btn7)
            }
            btn8 -> {
                assignImageToBotton(8, btn8)
            }
            btn9 -> {
                assignImageToBotton(9, btn9)
            }
            btn10 -> {
                assignImageToBotton(10, btn10)
            }
            btn11 -> {
                assignImageToBotton(11, btn11)
            }
            btn12 -> {
                assignImageToBotton(12, btn12)
            }
        }
    }

    private fun assignImageToBotton(buttonNumber: Int, v: View)  {
        val resource = imagesOriginal.getValue(results.getValue(buttonNumber))
        v.setBackgroundResource(resource)
        val action = validateCards(resource)

        if (!action) v.setBackgroundResource(R.drawable.ic_launcher_foreground)
    }

    private fun validateCards(resource: Int?): Boolean {
        if (actualCard != null) {
            if (actualCard != resource) {
                actualCard = null
                return false
            }
        } else {
            actualCard = resource
        }

        return true
    }

    private fun loadImagesToButtons() {
        val buttons = mutableListOf(1,2,3,4,5,6,7,8,9,10,11,12)
        val images = mutableMapOf("image0" to 0, "image1" to 0, "image2" to 0, "image3" to 0, "image4" to 0, "image5" to 0)

        var loop = 0
        var actualImage = "image$loop"

        while(loop < 6) {

            for (item in buttons) {
                if (images.getValue(actualImage) < 2) {
                    results[item] = actualImage
                    images[actualImage] = images[actualImage]!!.plus(1)

                } else break
            }

            for((key) in results) {
                if (buttons.contains(key))
                    buttons.remove(key)
            }

            loop++
            actualImage = "image$loop"
        }
    }
}
