package com.xenia.retrofit2kotlin.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.xenia.retrofit2kotlin.network.User
import com.xenia.retrofit2kotlin.network.UserNetwork
import kotlinx.coroutines.launch

class MainActivityViewModel : ViewModel() {
    val myResponse: MutableLiveData<User> = MutableLiveData()
    val myResponseList: MutableLiveData<List<User>> = MutableLiveData()

    fun getPost() {
        viewModelScope.launch {
            myResponse.value = UserNetwork.retrofit.getPost()
        }
    }

    fun getPosts() {
        viewModelScope.launch {
            myResponseList.value = UserNetwork.retrofit.getPosts()
        }
    }
}