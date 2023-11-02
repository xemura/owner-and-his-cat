package com.xenia.retrofit2kotlin

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.RecyclerView
import com.xenia.retrofit2kotlin.adapter.RecyclerViewAdapter
import com.xenia.retrofit2kotlin.databinding.ActivityMainBinding
import com.xenia.retrofit2kotlin.model.Cat
import com.xenia.retrofit2kotlin.model.Owner
import com.xenia.retrofit2kotlin.viewmodel.MainActivityViewModel

class MainActivity : AppCompatActivity() {
    private val tag = "MainActivity"
    private lateinit var binding: ActivityMainBinding
    private lateinit var recyclerView: RecyclerView
    private lateinit var recyclerViewAdapter: RecyclerViewAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val viewModel = ViewModelProvider(this)[MainActivityViewModel::class.java]

        recyclerView = binding.recyclerView

        var listOwners : List<Owner> = listOf()
        var listCats: List<Cat> = listOf()

        viewModel.getOwners()
        viewModel.myResponseListOwners.observe(this, Observer {
            listOwners = it
        })

        viewModel.getImages()
        viewModel.myResponseListImagesOfCats.observe(this, Observer {
            listCats = it
        })

        binding.btnRefresh.setOnClickListener {
            recyclerViewAdapter = RecyclerViewAdapter(listOwners, listCats)
            recyclerView.adapter = recyclerViewAdapter

            viewModel.getOwners()
            viewModel.getImages()
        }
    }
}