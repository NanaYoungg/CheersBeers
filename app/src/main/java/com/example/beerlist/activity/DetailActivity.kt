package com.example.beerlist.activity

import android.net.Uri
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
        val mName: TextView = findViewById(R.id.tv_dtail_name)
        val mImage: ImageView = findViewById(R.id.iv_detail_image)

        var name = intent.getStringExtra("name")
        var image = intent.getStringExtra("image")

        //이름
        mName.setText(name)
        //사진
        Glide.with(this).load(image).into(mImage)


    }
}