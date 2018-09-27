package com.example.chris.kotlinapp.activities

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import com.example.chris.kotlinapp.R
import com.google.firebase.auth.FirebaseAuth
import kotlinx.android.synthetic.main.activity_login.*
import android.widget.Toast
import android.support.v7.app.AlertDialog

//import com.example.chris.kotlinapp.models.User


class LoginActivity : AppCompatActivity() {

    private var mAuth: FirebaseAuth? = null

    override fun onStart() {
        super.onStart()
        val currentUser = mAuth?.currentUser
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        mAuth = FirebaseAuth.getInstance()

        loginButton.setOnClickListener() { _ ->
            mAuth?.signInWithEmailAndPassword(usernameEditText.text.toString(), passwordEditText.text.toString())
                    ?.addOnCompleteListener(this) { task ->
                        if (task.isSuccessful) {
                            // Sign in success, update UI with the signed-in user's information
                            val user = mAuth?.currentUser
                            val intent: Intent = Intent(this, MainActivity::class.java)
//                            intent.putExtra("user", User(user?.displayName, user?.email))
                            startActivity(intent)
                            finish()
                        } else {
                            // If sign in fails, display a message to the user.
                            showAlertDialog("Authentication failed")
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
}
