package com.example.cc_e90045.kotlinapp.activities

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.view.MenuItem
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView

abstract class BaseActivity : AppCompatActivity(){

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

    private fun setEnabled(parent: ViewGroup,enabled: Boolean){
        for (i in 0..parent.childCount - 1 ){
            val child: View = parent.getChildAt(i)
            if (child is ViewGroup){
                setEnabled(child, enabled)
            }else if (child is TextView || child is Button){
                child.setEnabled(enabled)
            }
        }
    }
}