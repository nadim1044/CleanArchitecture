package com.example.demoarchitecture.domain.use_case

import com.example.demoarchitecture.data.model.PaginationModel
import com.example.demoarchitecture.domain.repository.Repository
import com.example.demoarchitecture.utils.Resource
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class DemoUseCase @Inject constructor(private val repository: Repository) {
    operator fun invoke(): Flow<Resource<PaginationModel?>> {
        return repository.demo()
    }
}