package com.example.demoarchitecture.data.api

import com.example.demoarchitecture.data.model.res.DemoResponse
import retrofit2.Response
import retrofit2.http.GET

interface ApiService {

    @GET("users")
    suspend fun getDemo(): Response<DemoResponse>
}