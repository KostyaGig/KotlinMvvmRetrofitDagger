package com.kostya_ubutnu.kotlinmvvmretrofitrxdagger

import android.app.Application
import com.kostya_ubutnu.kotlinmvvmretrofitrxdagger.services.NetworkApi
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory

class App : Application() {

    override fun onCreate() {
        super.onCreate()
    }
}