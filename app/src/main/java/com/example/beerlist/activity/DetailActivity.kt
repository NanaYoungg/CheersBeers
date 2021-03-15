package com.example.beerlist.activity

import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.bumptech.glide.Glide
import com.example.beerlist.R


class DetailActivity : AppCompatActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail)

        //어댑터에 PutExtra값 받기
        val name: TextView = findViewById(R.id.dtail_beer_name_tv)
        val image: ImageView = findViewById(R.id.detail_beer_iv)

        var mName = intent.getStringExtra("name")
        var mImage = intent.getStringExtra("image")

        //이름
        name.setText(mName)
        //사진
        Glide.with(this).load(mImage).into(image)


    }
}