package com.example.login.activities

import android.content.Intent
import android.os.Bundle
import com.google.firebase.auth.FirebaseAuth
import kotlinx.android.synthetic.main.activity_login.*
import android.support.v7.app.AlertDialog
import com.example.chris.validations.activities.BaseActivity
import com.example.login.Application
import com.example.login.R
import com.example.login.R.id.*

//import com.example.chris.kotlinapp.models.User


class LoginActivity : BaseActivity() {

    private var application: Application? = null

    private var mAuth: FirebaseAuth? = null

    override fun onStart() {
        super.onStart()
        val currentUser = mAuth?.currentUser
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        try {
            application = applicationContext as Application
        } catch (e: ClassCastException) {
            throw ClassCastException("Application must implement Application")
        }


        mAuth = FirebaseAuth.getInstance()

        loginButton.setOnClickListener() { _ ->
            validateErrors()
            if (!hasError()) {
                mAuth?.signInWithEmailAndPassword(usernameEditText.text.toString(), passwordEditText.text.toString())
                        ?.addOnCompleteListener(this) { task ->
                            if (task.isSuccessful) {
                                // Sign in success, update UI with the signed-in user's information
                                val user = mAuth?.currentUser
                                application?.onLoginSuccess()
                                finish()
                            } else {
                                // If sign in fails, display a message to the user.
                                showAlertDialog("Authentication failed")
                            }
                        }
            }
        }
    }

    private fun showAlertDialog(message: String) {
        AlertDialog.Builder(this)
                .setMessage(message)
                .setCancelable(false)
                .setPositiveButton("Aceptar", null)
                .show()
    }

    override fun validateErrors() {
        super.validateErrors()

    }
}
