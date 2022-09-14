package com.example.demoarchitecture.utils

sealed class Resource<T> {

    class Loading<T>(val data: T?) : Resource<T>()
    class Success<T>(val data: T) : Resource<T>()
    class Error<T>(val code: Int, val message: String) : Resource<T>()

}