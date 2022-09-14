package com.example.demoarchitecture.data.repository_imp

import com.example.demoarchitecture.data.PreferenceManager
import com.example.demoarchitecture.data.api.ApiService
import com.example.demoarchitecture.data.api.RemoteSource
import com.example.demoarchitecture.data.model.res.DemoResponse
import com.example.demoarchitecture.domain.repository.Repository
import com.example.demoarchitecture.utils.Resource
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import javax.inject.Inject

class RepositoryImp @Inject constructor(
    private val apiService: RemoteSource,
    val preferenceManager: PreferenceManager) : Repository {

    //    override fun login(email: String, password: String): Flow<Resource<SignInResponse>> {
//        return flow {
//            val response = remote.login(email, password)
//
//            // TODO add data into local database if required
//            // TODO Dao calls to store or retrieve data from the local database
//
//            // TODO save login related information here for the login
//            if (response is Resource.Success) {
//                preferenceManager.saveLoginInfo(response.data.data.user)
//            }
//            emit(response)
//        }
//    }
//
//    override fun forgotPassword(email: String): Flow<Resource<ForgotpasswordResponse>> {
//        return flow {
//            val response = remote.forgotPassword(email)
//            emit(response)
//        }
//    }
    override fun demo(): Flow<Resource<DemoResponse?>> {
        return flow {
            val response = apiService.demoCalling()
            emit(response)
        }
    }
}