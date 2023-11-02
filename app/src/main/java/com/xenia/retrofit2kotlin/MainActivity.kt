package com.xenia.retrofit2kotlin

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.xenia.retrofit2kotlin.databinding.ActivityMainBinding
import com.xenia.retrofit2kotlin.viewmodel.MainActivityViewModel

class MainActivity : AppCompatActivity() {
    private val tag = "MainActivity"
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val viewModel = ViewModelProvider(this)[MainActivityViewModel::class.java]

        viewModel.getUsers()
        viewModel.myResponseList.observe(this, Observer {
            for (user in it) {
                Log.d(tag, user.userName)
                Log.d(tag, user.website)
                Log.d(tag, user.id)
            }
        })
    }
}