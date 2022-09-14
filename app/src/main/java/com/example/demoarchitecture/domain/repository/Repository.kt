package com.example.demoarchitecture.domain.repository

import com.example.demoarchitecture.data.model.res.DemoResponse
import com.example.demoarchitecture.utils.Resource
import kotlinx.coroutines.flow.Flow
import retrofit2.http.GET

interface Repository {


    fun demo(): Flow<Resource<DemoResponse?>>
}