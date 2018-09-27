package com.example.chris.validations.helpers

import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView

abstract class ErrorHelper {

    companion object {

        fun setEnabled(parent: ViewGroup, enabled: Boolean){
            for (i in 0..parent.childCount - 1 ){
                val child: View = parent.getChildAt(i)
                if (child is ViewGroup){
                    setEnabled(child, enabled)
                }else if (child is TextView || child is Button){
                    child.setEnabled(enabled)
                }
            }
        }

        fun findError(parent: ViewGroup) : Boolean{
            var error : Boolean = false
            for(i in 0..parent.childCount -1){
                val child: View = parent.getChildAt(i)
                if(child is ViewGroup) {
                    findError(child)
                }else if (child is TextView){
                    if (child.error != null){
                        error = true
                        break
                    }
                }
            }
            return error;
        }

        fun focusError(parent: ViewGroup){
            for (i in 0..parent.childCount){
                val child: View = parent.getChildAt(i)
                if(child is ViewGroup){
                    focusError(child)
                }else if (child is TextView){
                    child.requestFocus()
                    return
                }
            }
        }

        fun clearErrors(parent: ViewGroup){
            for(i in 0..parent.childCount){
                val child = parent.getChildAt(i)
                if(child is ViewGroup){
                    clearErrors(child)
                }else if (child is TextView){
                    child.error = null
                }
            }
        }

    }

}