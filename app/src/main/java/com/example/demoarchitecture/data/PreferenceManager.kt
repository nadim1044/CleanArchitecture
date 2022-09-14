package com.example.demoarchitecture.data

import android.content.SharedPreferences
import com.example.demoarchitecture.utils.Logger
import javax.inject.Inject

class PreferenceManager @Inject constructor(private val sharedPreferences: SharedPreferences) {

    companion object {
        private val TAG = Logger.makeLogTag("PreferenceManager")
        val USER = "User_data"
        val KEEPME = "Keep_me"
        val USEREMAIL = "User_email"
        val USERPASSWORD = "User_password"
    }

    init {
        Logger.e(TAG, "init()")
    }

//    fun saveLoginInfo(user: User) {
//        val editor = sharedPreferences.edit()
//        editor.putString(USER, Utility.gsonWithExpose().toJson(user))
//        editor.apply()
//    }
//
//    fun getUserInfo(): User? {
//        if (sharedPreferences.getString(USER, null) != null) {
//            val user = sharedPreferences.getString(USER, null)
//            return Utility.gsonWithExpose().fromJson(user, User::class.java)
//        }
//        return null
//    }
//
//    fun saveKeepMe(isKeepMe: Boolean, email: String, password: String) {
//        val editor = sharedPreferences.edit()
//        editor.putBoolean(KEEPME, isKeepMe)
//        editor.putString(USEREMAIL, email)
//        editor.putString(USERPASSWORD, password)
//        editor.apply()
//    }
}