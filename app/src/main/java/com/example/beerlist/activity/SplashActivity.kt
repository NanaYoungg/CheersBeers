package com.example.beerlist.activity

import android.content.Intent
import android.os.Bundle
import android.os.Handler
import android.view.WindowManager
import android.widget.ImageView
import androidx.appcompat.app.AppCompatActivity
import com.bumptech.glide.Glide
import com.example.beerlist.R

class SplashActivity  : AppCompatActivity() {

    val SPLASH_VIEW_TIME: Long = 3000 //3초

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        //상태바 제거 풀스크린으로
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_splash)

        //이미지뷰에 GIF
        val imageView: ImageView = findViewById(R.id.iv_splash)
        Glide.with(this).load(R.drawable.splash_beer_gif).into(imageView)

        //delay를 위한 handler
        Handler().postDelayed({
            startActivity(Intent(this, MainActivity::class.java))
            finish()
        }, SPLASH_VIEW_TIME)
    }
}