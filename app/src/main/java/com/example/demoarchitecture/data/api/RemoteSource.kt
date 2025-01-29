package com.example.demoarchitecture.data.api

import com.example.demoarchitecture.data.model.PaginationModel
import com.example.demoarchitecture.utils.Logger
import com.example.demoarchitecture.utils.Resource
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Inject

@Module
@InstallIn(SingletonComponent::class)
class RemoteSource @Inject constructor(private val service: ApiService) {

    companion object {
        private const val TAG = "RemoteSource"
        private const val ERROR_100 = 100
        private const val DEFAULT_ERROR_MESSAGE = "Something went wrong"
    }

    suspend fun demoCalling(): Resource<PaginationModel?> {
        return try {
            val response = service.getDemo()
            if (response.isSuccessful && response.body() != null) {
                val data = response.body()
                Resource.Success(data)
            } else {
                Resource.Error(response.code(), response.message())
            }
        } catch (e: Exception) {
            Logger.e(TAG, "login() $e")
            Resource.Error(
                ERROR_100,
                DEFAULT_ERROR_MESSAGE
            )
        }
    }

//    suspend fun login(email: String, password: String): Resource<SignInResponse> {
//        return try {
//            val response = service.signInUser(email, password)
//            if (response.isSuccessful) {
//                val data = response.body()
//                if (data?.responseCode == HttpURLConnection.HTTP_OK && data.success) {
//                    Resource.Success(data)
//                } else {
//                    Resource.Error(
//                        data?.responseCode ?: ERROR_100,
//                        data?.message ?: DEFAULT_ERROR_MESSAGE
//                    )
//                }
//            } else {
//                Resource.Error(response.code(), response.message())
//            }
//        } catch (e: Exception) {
//            Logger.e(TAG, "login() $e")
//            Resource.Error(
//                ERROR_100,
//                DEFAULT_ERROR_MESSAGE
//            )
//        }
//    }


}