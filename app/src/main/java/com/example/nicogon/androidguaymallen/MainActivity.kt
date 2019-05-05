package com.example.nicogon.androidguaymallen

import android.os.Bundle
import android.support.design.widget.BottomNavigationView
import android.support.v7.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_main.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import com.example.nicogon.androidguaymallen.network.ApiClient
import com.example.nicogon.androidguaymallen.network.HttpConstants

class MainActivity : AppCompatActivity(), Callback<TVModel> {

    private val mOnNavigationItemSelectedListener = BottomNavigationView.OnNavigationItemSelectedListener { item ->
        when (item.itemId) {
            R.id.navigation_home -> {
                message.setText(R.string.title_home)
                return@OnNavigationItemSelectedListener true
            }
            R.id.navigation_dashboard -> {
                message.setText(R.string.title_dashboard)
                return@OnNavigationItemSelectedListener true
            }
            R.id.navigation_notifications -> {
                message.setText(R.string.title_notifications)
                return@OnNavigationItemSelectedListener true
            }
        }
        false
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        navigation.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener)
        ApiClient.apiInterface.getPopular(HttpConstants.API_KEY).enqueue(this)

    }

    override fun onFailure(call: Call<TVModel>?, t: Throwable?) {
        print("hola")
    }

    override fun onResponse(call: Call<TVModel>?, response: Response<TVModel>?) {
        if (response!!.isSuccessful) {
            //en response esta todo lo que se necesita ya modelado. ahi hay un for de como ir uno por uno viendo algo que necesitemos
            print("Hola")
//            for (item: TVModel.ResultsEntity in response.body().results!!) {
//                println(item.original_name)
//            }

//            var recyclerAdapter = RecyclerViewAdapter(this, response.body().results!!)
//            recyclerView!!.adapter = recyclerAdapter
        }    }
}
