package com.xenia.retrofit2kotlin.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.xenia.retrofit2kotlin.model.Cat
import com.xenia.retrofit2kotlin.model.Owner
import com.xenia.retrofit2kotlin.network.interfaces.CatApi
import com.xenia.retrofit2kotlin.network.interfaces.OwnerApi
import kotlinx.coroutines.launch

class MainActivityViewModel : ViewModel() {
    private var _myResponseListImagesOfCats : MutableLiveData<List<Cat>> = MutableLiveData()
    val myResponseListImagesOfCats: LiveData<List<Cat>> = _myResponseListImagesOfCats

    private var _myResponseListOwners : MutableLiveData<List<Owner>> = MutableLiveData()
    val myResponseListOwners: LiveData<List<Owner>> = _myResponseListOwners

    fun getImages() {
        viewModelScope.launch {
            _myResponseListImagesOfCats.value = CatApi.retrofitServiceCats.getCats()
        }
    }

    fun getOwners() {
        viewModelScope.launch {
            _myResponseListOwners.value = OwnerApi.retrofitService.getOwners()
        }
    }
}