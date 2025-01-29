package com.example.demoarchitecture.data.repository_imp

import com.example.demoarchitecture.data.PreferenceManager
import com.example.demoarchitecture.data.api.RemoteSource
import com.example.demoarchitecture.data.model.PaginationModel
import com.example.demoarchitecture.domain.repository.Repository
import com.example.demoarchitecture.utils.Resource
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import javax.inject.Inject

class RepositoryImp @Inject constructor(
    private val apiService: RemoteSource,
    val preferenceManager: PreferenceManager
) : Repository {

    override fun demo(): Flow<Resource<PaginationModel?>> {
        return flow {
            val response = apiService.demoCalling()
            emit(response)
        }
    }
}