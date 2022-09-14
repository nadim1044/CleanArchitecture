package com.example.demoarchitecture.utils

import android.app.Activity
import android.content.Context
import android.graphics.Color
import android.view.View
import android.view.inputmethod.InputMethodManager
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.google.android.material.snackbar.Snackbar
import com.google.gson.Gson
import com.google.gson.GsonBuilder

import java.util.regex.Pattern

    object Utility {

    private val PASSWORD_PATTERN = Pattern.compile("^(?=.*?[a-zA-Z])(?=.*?[0-9]).{6,}$")
    private val TAG = Utility::class.java.simpleName
    private var snackbar: Snackbar? = null

    fun hideKeyboard(aContext: Activity?) {
        if (aContext != null) {
            val im =
                aContext.getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
            im.hideSoftInputFromWindow(
                aContext.window.decorView.windowToken,
                InputMethodManager.HIDE_NOT_ALWAYS
            )
        }
    }

    fun showKeyboard(aEditText: EditText, aContext: AppCompatActivity?) {
        if (aContext != null) {
            val im =
                aContext.getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
            im.showSoftInput(aEditText, InputMethodManager.SHOW_IMPLICIT)
        }
    }

    fun showSnackBar(view: View, message: String, time: Int, isTypeError: Boolean) {
        snackbar = Snackbar.make(view, message, time)
        val snackBarView = snackbar!!.view

        if (isTypeError)
            snackBarView.setBackgroundColor(Color.parseColor("#E41200"))
        else
            snackBarView.setBackgroundColor(Color.parseColor("#34A853"))

        snackbar!!.show()
    }

    fun hideSnackBar() {
        if (snackbar != null && snackbar!!.isShown) {
            snackbar!!.dismiss()
        }
    }

    fun checkEmail(email: String): Boolean {

        val findStr = ".com"
        val findStrIn = ".in"
        var lastIndex = 0
        var count = 0

        while (lastIndex != -1) {
            lastIndex = email.indexOf(findStr, lastIndex)
            if (lastIndex != -1) {
                count++
                lastIndex += findStr.length
            }
        }

        while (lastIndex != -1) {
            lastIndex = email.indexOf(findStrIn, lastIndex)
            if (lastIndex != -1) {
                count++
                lastIndex += findStr.length
            }
        }

        return android.util.Patterns.EMAIL_ADDRESS.matcher(email).matches() && count == 1
    }

    fun checkPassword(password: String): Boolean {
        return PASSWORD_PATTERN.matcher(password).matches()
    }

    fun showToast(context: Context, msg: String) {
        Toast.makeText(
            context,
            msg,
            Toast.LENGTH_SHORT
        ).show()
    }


    fun gsonWithoutExpose(): Gson {
        return GsonBuilder().setLenient().excludeFieldsWithoutExposeAnnotation().create()
    }

    fun gsonWithExpose(): Gson {
        return GsonBuilder().setLenient().create()
    }
}