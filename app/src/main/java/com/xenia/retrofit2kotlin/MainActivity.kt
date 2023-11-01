package com.xenia.retrofit2kotlin

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.xenia.retrofit2kotlin.databinding.ActivityMainBinding
import com.xenia.retrofit2kotlin.viewmodel.MainActivityViewModel

class MainActivity : AppCompatActivity() {
    private val TAG = "MainActivity"
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val viewModel = ViewModelProvider(this)[MainActivityViewModel::class.java]

        viewModel.getPost()
        viewModel.myResponse.observe(this, Observer {
            Log.d(TAG, it.body)
            Log.d(TAG, it.title)
            Log.d(TAG, it.id.toString())
            Log.d(TAG, it.userId.toString())
        })

        viewModel.getPosts()
        viewModel.myResponseList.observe(this, Observer {
            for (user in it) {
                Log.d(TAG, user.body)
                Log.d(TAG, user.title)
                Log.d(TAG, user.id.toString())
                Log.d(TAG, user.userId.toString())
            }
        })
    }
}