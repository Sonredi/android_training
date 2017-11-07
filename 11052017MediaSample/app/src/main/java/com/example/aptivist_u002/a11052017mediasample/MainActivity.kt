package com.example.aptivist_u002.a11052017mediasample

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    val TYPE_MEDIA = 1
    val TYPE_VIDEO = 2
    val TYPE_EXOPLAYER = 3


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

    a_main_btn1.setOnClickListener{triggerActivity(TYPE_MEDIA)}
    a_main_btn2.setOnClickListener{triggerActivity(TYPE_VIDEO)}
    a_main_btn3.setOnClickListener{triggerActivity(TYPE_EXOPLAYER)}

    }

    private fun triggerActivity(typeActivity: Int) {
        val intent = when (typeActivity){
            TYPE_MEDIA -> Intent(this, MediaPlayerActivity::class.java)
            TYPE_VIDEO -> Intent(this, VideoViewActivity::class.java)
                else -> Intent(this, ExoPlayerActivity::class.java)
        }
        startActivity(intent)
    }
}
