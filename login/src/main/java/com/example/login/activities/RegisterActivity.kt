package com.example.login.activities

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v7.app.AlertDialog
import com.example.chris.validations.activities.BaseActivity
import com.example.login.R
import com.google.firebase.auth.FirebaseAuth
import kotlinx.android.synthetic.main.activity_register.*
import android.widget.Toast
import com.example.login.Application

class RegisterActivity : BaseActivity() {

    private var application: Application? = null

    private var mAuth: FirebaseAuth? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_register)

        try {
            application = applicationContext as? Application
        } catch (e: ClassCastException) {
            throw ClassCastException("Application must implement Application")
        }

        mAuth = FirebaseAuth.getInstance()

        registerButton.setOnClickListener() {_ ->
            mAuth?.createUserWithEmailAndPassword(mailEditText.text.toString(), passwordEditText.text.toString())
                    ?.addOnCompleteListener(this) { task ->
                        if (task.isSuccessful) {
                            // Sign in success, update UI with the signed-in user's information
                            application?.setUser(mailEditText.text.toString())
                            finish()
                        } else {
                            showAlertDialog("Falló el registro. Intentálo más tarde")
                        }
                    }
        }
    }

    override fun showAlertDialog(message: String) {
        AlertDialog.Builder(this)
                .setMessage(message)
                .setCancelable(false)
                .setPositiveButton("Aceptar", null)
                .show()
    }
}
