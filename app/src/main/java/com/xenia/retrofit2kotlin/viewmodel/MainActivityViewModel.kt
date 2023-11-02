package com.xenia.retrofit2kotlin.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.xenia.retrofit2kotlin.model.Cat
import com.xenia.retrofit2kotlin.model.User
import com.xenia.retrofit2kotlin.network.interfaces.CatApi
import com.xenia.retrofit2kotlin.network.interfaces.UserApi
import kotlinx.coroutines.launch

class MainActivityViewModel : ViewModel() {
    private var _myResponseListImagesOfCats : MutableLiveData<List<Cat>> = MutableLiveData()
    val myResponseListImagesOfCats: LiveData<List<Cat>> = _myResponseListImagesOfCats

    private var _myResponseListUsers : MutableLiveData<List<User>> = MutableLiveData()
    val myResponseListUsers: LiveData<List<User>> = _myResponseListUsers

    fun getImages() {
        viewModelScope.launch {
            _myResponseListImagesOfCats.value = CatApi.retrofitServiceCats.getCats()
        }
    }

    fun getOwners() {
        viewModelScope.launch {
            _myResponseListUsers.value = UserApi.retrofitService.getOwners()
        }
    }
}