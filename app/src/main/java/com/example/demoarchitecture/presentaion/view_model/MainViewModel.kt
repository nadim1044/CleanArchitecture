package com.example.demoarchitecture.presentaion.view_model

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.demoarchitecture.domain.use_case.DemoUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel class MainViewModel @Inject constructor(val useCase: DemoUseCase)  : ViewModel() {
    fun callApi() {
        viewModelScope.launch(Dispatchers.IO) {
            useCase.invoke().collect {
                Log.e("TAG","Response : $it")
            }
        }
    }
}