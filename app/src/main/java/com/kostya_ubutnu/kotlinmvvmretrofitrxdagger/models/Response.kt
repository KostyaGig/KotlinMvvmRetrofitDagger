package com.kostya_ubutnu.kotlinmvvmretrofitrxdagger.models

import com.google.gson.annotations.SerializedName

class Response() {
    @SerializedName("userId")
    private var userId:Int = 0
    get(){
        return field
    }

    @SerializedName("id")
    private var id:Int = 0
        get(){
            return field
        }

    @SerializedName("title")
    private var title:String? = null
        get(){
            return field
        }

    @SerializedName("body")
    private var body:String? = null
        get(){
            return field
        }

}