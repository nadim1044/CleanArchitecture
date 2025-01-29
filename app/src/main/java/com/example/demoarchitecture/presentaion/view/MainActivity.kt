package com.example.demoarchitecture.presentaion.view

import android.os.Bundle
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.demoarchitecture.R
import com.example.demoarchitecture.databinding.ActivityMainBinding
import com.example.demoarchitecture.presentaion.view.adapter.UserAdapter
import com.example.demoarchitecture.presentaion.view_model.MainViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {
    private val viewModel: MainViewModel by viewModels()


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding: ActivityMainBinding =
            DataBindingUtil.setContentView(this, R.layout.activity_main)


        binding.recyclerView.layoutManager = LinearLayoutManager(this)
        binding.recyclerView.adapter = UserAdapter(emptyList())

        viewModel.data.observe(this) { value ->
            binding.recyclerView.adapter = UserAdapter(value)
        }

        binding.txtHelloWorld.setOnClickListener {
            viewModel.callApi()
        }
    }
}