package com.example.login

import com.chris.models.User

interface Application {
    fun onLoginSuccess()
    fun getUser() : User?
    fun setUser(email: String)
}