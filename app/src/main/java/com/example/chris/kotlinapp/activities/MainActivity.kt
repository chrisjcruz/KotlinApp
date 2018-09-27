package com.example.chris.kotlinapp.activities

import android.os.Bundle
import com.example.chris.kotlinapp.R
import com.example.chris.validations.activities.BaseActivity

class MainActivity : BaseActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }
}
