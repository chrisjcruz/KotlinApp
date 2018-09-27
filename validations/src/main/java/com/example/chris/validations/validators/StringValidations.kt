package com.example.chris.validations.validators

import android.widget.TextView

class StringValidations {
    companion object {

        fun validatePasswordLength(view: TextView){
            if(view.text.toString().length < 6 ||  view.text.toString().length > 14){
                view.setError("La contraseña debe tener entre 6 y 14 caracteres")
            }
        }

        fun validateEmail(view: TextView){
            if (!android.util.Patterns.EMAIL_ADDRESS.matcher(view.text.toString()).find()){
                view.setError("Mail incorrecto")
            }
        }

    }
}