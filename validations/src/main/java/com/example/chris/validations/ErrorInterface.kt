package com.example.chris.validations

interface ErrorInterface {
    fun setEnabled(enabled : Boolean)
    fun validateErrors()
    fun clearErrors()
    fun focusError()
    fun hasError(): Boolean
}