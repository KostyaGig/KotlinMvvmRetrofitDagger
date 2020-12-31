package com.kostya_ubutnu.kotlinmvvmretrofitrxdagger.activities

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.ViewModelProviders
import com.kostya_ubutnu.kotlinmvvmretrofitrxdagger.R
import com.kostya_ubutnu.kotlinmvvmretrofitrxdagger.domains.viewmodels.MainViewModel

class MainActivity : AppCompatActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        var viewModel:MainViewModel = ViewModelProvider(this).get(MainViewModel::class.java)
        viewModel.getPosts()
        viewModel.getData()?.observe(this, Observer {
            if (it != null){
                Log.d("hththt","it not null")
            }
            for (i in it){
                Log.d("hththt", i.toString())
            }
        })
    }
}
