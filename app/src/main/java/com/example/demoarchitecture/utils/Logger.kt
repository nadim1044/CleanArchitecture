package com.example.demoarchitecture.utils

import android.util.Log
import com.example.demoarchitecture.BuildConfig


class Logger {

    companion object {

        private const val MAX_LOG_TAG_LENGTH = 23

        fun d(tag: String, message: String) {
            if (BuildConfig.DEBUG) {
                Log.d(tag, message)
            }
        }

        fun e(tag: String, message: String) {
            if (BuildConfig.DEBUG) {
                Log.e(tag, message)
            }
        }

        fun i(tag: String, message: String) {
            if (BuildConfig.DEBUG) {
                Log.i(tag, message)
            }
        }

        fun makeLogTag(str: String): String {
            if (str.length > MAX_LOG_TAG_LENGTH) {
                return str.substring(0, MAX_LOG_TAG_LENGTH - 1)
            }
            return str
        }

    }
}