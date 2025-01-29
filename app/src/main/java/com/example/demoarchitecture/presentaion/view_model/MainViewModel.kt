package com.example.demoarchitecture.presentaion.view_model

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.demoarchitecture.data.model.UserModel
import com.example.demoarchitecture.domain.use_case.DemoUseCase
import com.example.demoarchitecture.utils.Logger
import com.example.demoarchitecture.utils.Resource
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class MainViewModel @Inject constructor(private val useCase: DemoUseCase) : ViewModel() {

    private val _data = MutableLiveData<ArrayList<UserModel>>()
    val data: LiveData<ArrayList<UserModel>> get() = _data

    init {
        callApi()
    }

    fun callApi() {
        Logger.e("TAG", "Response : $useCase")
        viewModelScope.launch {
            useCase.invoke().collect { resource ->
                when (resource) {
                    is Resource.Success -> {
                        val userModel: List<UserModel>? =
                            resource.data?.data // Ensure `user` exists
                        userModel?.let {
                            _data.postValue(it as ArrayList<UserModel>?)
                        }
                    }

                    is Resource.Error -> {
                        Logger.e("TAG", "Error: ${resource.message}")
                    }

                    is Resource.Loading -> {
                        Logger.e("TAG", "Loading...")
                    }
                }
            }
        }
    }
}