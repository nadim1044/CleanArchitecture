package com.example.demoarchitecture.domain.use_case

import com.example.demoarchitecture.data.model.res.DemoResponse
import com.example.demoarchitecture.domain.repository.Repository
import com.example.demoarchitecture.utils.Resource
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class DemoUseCase @Inject constructor(private val repository:Repository) {
    operator fun invoke(): Flow<Resource<DemoResponse?>> {
        return repository.demo()
    }
}