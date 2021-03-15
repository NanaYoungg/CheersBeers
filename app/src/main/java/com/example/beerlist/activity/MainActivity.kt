package com.example.beerlist.activity

import android.app.ProgressDialog
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.beerlist.R
import com.example.beerlist.adapter.DataAdpter
import com.example.beerlist.model.BeerData
import com.example.beerlist.network.ApiClient
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MainActivity : AppCompatActivity() {

    lateinit var progerssProgressDialog: ProgressDialog
    var dataList = ArrayList<BeerData>()
    lateinit var recyclerView: RecyclerView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        recyclerView = findViewById(R.id.beer_main_recycler_view)
        //어댑터 설정
        recyclerView.adapter = DataAdpter(dataList, this)
        //LinearLayoutManager
        recyclerView.layoutManager = LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false)

        //무한스크롤
        recyclerView.addOnScrollListener(object : RecyclerView.OnScrollListener() {
            override fun onScrolled(recyclerView: RecyclerView, dx: Int, dy: Int) {
                super.onScrolled(recyclerView, dx, dy)

                val lastVisibleItemPosition =
                    (recyclerView.layoutManager as LinearLayoutManager).findLastCompletelyVisibleItemPosition()
                val itemTotalCount = recyclerView.adapter?.itemCount
                //리스트 마지막에 도착했을때
                if (lastVisibleItemPosition + 1 == itemTotalCount) {
                    progerssProgressDialog.show()
                    getBeerData()
                }
            }

        })


        //progerssProgressDialog 통신 로딩시 빙글빙글
        progerssProgressDialog = ProgressDialog(this)
        progerssProgressDialog.setTitle("Loading")
        progerssProgressDialog.setCancelable(false)
        progerssProgressDialog.show()
        getBeerData()

    }

    private fun getBeerData() {
        //endpoint 호출
        val call: Call<List<BeerData>> = ApiClient.getClient.getBeers()
        call.enqueue(object : Callback<List<BeerData>> {

            //데이터가 받아지면
            override fun onResponse(
                call: Call<List<BeerData>>?,
                response: Response<List<BeerData>>?
            ) {
                progerssProgressDialog.dismiss()
                dataList.addAll(response!!.body()!!)
                recyclerView.adapter?.notifyDataSetChanged()
            }

            //데이터 받기 실패하면
            override fun onFailure(call: Call<List<BeerData>>?, t: Throwable?) {
                progerssProgressDialog.dismiss()

            }

        })
    }


}
















