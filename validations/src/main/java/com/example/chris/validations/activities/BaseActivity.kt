package com.example.chris.validations.activities

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.view.MenuItem
import com.example.chris.validations.ErrorInterface
import com.example.chris.validations.helpers.ErrorHelper

abstract class BaseActivity : AppCompatActivity(), ErrorInterface{

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        if(supportActionBar != null)
            supportActionBar!!.setDisplayHomeAsUpEnabled(true)
    }

    override fun onOptionsItemSelected(item: MenuItem?): Boolean {
        if (item!!.itemId == android.R.id.home){
            super.onBackPressed()
            return true
        }
        return super.onOptionsItemSelected(item);
    }

    override fun setEnabled(enabled: Boolean) {
        ErrorHelper.setEnabled(findViewById(android.R.id.content), enabled)
    }

    override fun validateErrors() {
        clearErrors()
    }

    override fun clearErrors() {
        ErrorHelper.clearErrors(findViewById(android.R.id.content))
    }

    override fun focusError() {
        ErrorHelper.focusError(findViewById(android.R.id.content))
    }

    override fun hasError(): Boolean {
        return ErrorHelper.findError(findViewById(android.R.id.content))
    }
}