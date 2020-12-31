package com.kostya_ubutnu.kotlinmvvmretrofitrxdagger.services

import com.kostya_ubutnu.kotlinmvvmretrofitrxdagger.models.Response
import io.reactivex.Observable
import retrofit2.http.GET


interface NetworkApi {

    @GET("posts")
    fun getPosts():Observable<List<Response>>

}