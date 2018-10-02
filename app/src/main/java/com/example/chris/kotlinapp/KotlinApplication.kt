package com.example.chris.kotlinapp

import android.content.Intent
import android.support.multidex.MultiDexApplication
import com.chris.models.User
import com.example.chris.kotlinapp.activities.MainActivity
import com.example.login.Application

class KotlinApplication : MultiDexApplication(), Application {

    private var user: User? = null

    override fun onLoginSuccess() {
        val intent: Intent = Intent(this, MainActivity::class.java)
        intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK)
        startActivity(intent)
    }

    override fun getUser(): User? {
        return user
    }

    override fun setUser(email: String) {
        user = User(email)
    }
}