package com.example.demoarchitecture.domain.repository

import com.example.demoarchitecture.data.model.PaginationModel
import com.example.demoarchitecture.utils.Resource
import kotlinx.coroutines.flow.Flow

interface Repository {


    fun demo(): Flow<Resource<PaginationModel?>>
}