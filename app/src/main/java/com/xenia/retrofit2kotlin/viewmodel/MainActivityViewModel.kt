package com.xenia.retrofit2kotlin.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.xenia.retrofit2kotlin.network.User
import com.xenia.retrofit2kotlin.network.UserApi
import kotlinx.coroutines.launch

class MainActivityViewModel : ViewModel() {
    private var _myResponseList : MutableLiveData<List<User>> = MutableLiveData()
    val myResponseList: LiveData<List<User>> = _myResponseList

    fun getUsers() {
        viewModelScope.launch {
            _myResponseList.value = UserApi.retrofitService.getUsers()
        }
    }
}