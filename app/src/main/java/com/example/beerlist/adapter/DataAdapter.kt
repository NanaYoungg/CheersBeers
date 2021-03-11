package com.example.beerlist.adapter

import android.R.attr.src
import android.content.Context
import android.content.Intent
import android.graphics.BitmapFactory
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.beerlist.R
import com.example.beerlist.activity.DetailActivity
import com.example.beerlist.model.BeerData


class DataAdpter(private var dataList: List<BeerData>, private val context: Context) : RecyclerView.Adapter<DataAdpter.ViewHolder>() {


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(LayoutInflater.from(context).inflate(R.layout.item_beer_list, parent, false))
    }

    override fun getItemCount(): Int {
        return dataList.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val dataModel=dataList.get(position)
        holder.mBeerName.text=dataModel.name
        holder.mBeerTagline.text=dataModel.tagline

        //Glide 이미지 로드
        Glide.with(holder.itemView.getContext())
            .load(dataModel.image_url)
            .into(holder.mBeerImage)

        //화면 전환
        holder.itemView.setOnClickListener {
            val intent = Intent(holder.itemView?.context, DetailActivity::class.java)

            //데이터 보내기
            intent.putExtra("name", dataModel.name)
            intent.putExtra("image", dataModel.image_url)

            ContextCompat.startActivity(holder.itemView.context, intent, null)
        }


    }


    class ViewHolder(itemLayoutView: View) : RecyclerView.ViewHolder(itemLayoutView) {
        var mBeerName: TextView
        var mBeerTagline: TextView
        var mBeerImage: ImageView

        init {
            mBeerName=itemLayoutView.findViewById(R.id.tv_name)
            mBeerTagline=itemLayoutView.findViewById(R.id.tv_tagline)
            mBeerImage=itemLayoutView.findViewById(R.id.iv_img)

        }

    }
}