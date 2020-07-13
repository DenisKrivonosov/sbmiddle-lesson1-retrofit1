package ru.skillbranch.retrofit1

import androidx.appcompat.app.AppCompatActivity
//import android.os.Bundle

//import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
//import android.support.v7.widget.LinearLayoutManager
//import android.support.v7.widget.RecyclerView
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

import java.io.IOException
import java.util.ArrayList
import java.util.List

import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MainActivity : AppCompatActivity() {

    private lateinit var recyclerView: RecyclerView
    private var posts = mutableListOf<PostModel>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        recyclerView = findViewById(R.id.posts_recycle_view)
        val layoutManager = LinearLayoutManager(this)
        recyclerView.setLayoutManager(layoutManager)

        val adapter =  PostsAdapter(posts as List<PostModel>)
        recyclerView.adapter = adapter


        App.getApi().getData("Belgium").enqueue(object : Callback<List<PostModel>> {
            override fun onResponse(call: Call<List<PostModel>>, response: Response<List<PostModel>>) {
//                response.body().forEach()
                posts.addAll(response.body())
                (recyclerView.adapter as PostsAdapter).notifyDataSetChanged()
            }

            override fun onFailure(call: Call<List<PostModel>>, t: Throwable) {
                Log.e("error", t.toString())
                Toast.makeText(applicationContext,
                    "An error occurred during networking", Toast.LENGTH_SHORT).show()
            }
        })
    }
}