package com.kostya_ubutnu.kotlinmvvmretrofitrxdagger.domains.repositories

import androidx.lifecycle.MutableLiveData
import com.kostya_ubutnu.kotlinmvvmretrofitrxdagger.App
import com.kostya_ubutnu.kotlinmvvmretrofitrxdagger.models.Response
import com.kostya_ubutnu.kotlinmvvmretrofitrxdagger.services.NetworkApi
import io.reactivex.Observable
import io.reactivex.Scheduler
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory
import java.util.*

class MainRepositories {

    var mutableLiveData:MutableLiveData<List<Response>>? = MutableLiveData()
    lateinit var networkApi: NetworkApi

    companion object{
        val BASE_URL:String = "https://jsonplaceholder.typicode.com/"
    }

    fun getRetrofit(): Retrofit {
        val retrofit = Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
            .addConverterFactory(GsonConverterFactory.create())
            .build()
        return retrofit
    }


    fun getPosts(){
        networkApi = getRetrofit().create(NetworkApi::class.java)

        val data:Observable<List<Response>> = networkApi.getPosts()

        data
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe(
                {
                    mutableLiveData?.value = it
                },
                {
                    mutableLiveData?.value = null
                },
                {
                    print("OnComplete")
                }
            )
    }

    fun getLiveData(): MutableLiveData<List<Response>>? {
        return mutableLiveData
    }

}