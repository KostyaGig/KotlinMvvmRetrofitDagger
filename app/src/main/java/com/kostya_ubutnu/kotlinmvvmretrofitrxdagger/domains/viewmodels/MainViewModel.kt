package com.kostya_ubutnu.kotlinmvvmretrofitrxdagger.domains.viewmodels

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.kostya_ubutnu.kotlinmvvmretrofitrxdagger.domains.repositories.MainRepositories
import com.kostya_ubutnu.kotlinmvvmretrofitrxdagger.models.Response

public class MainViewModel:ViewModel(){

    var mutableLiveData:MutableLiveData<List<Response>>? = MutableLiveData()
    val repository:MainRepositories = MainRepositories()

    fun getPosts(){
        repository.getPosts()
        mutableLiveData = repository.getLiveData()
    }

    fun getData():MutableLiveData<List<Response>>?{
        return mutableLiveData
    }

}