package com.example.demoarchitecture.data.model

data class PaginationModel(
    val page: Int,
    val perPage: Int,
    val total: Int,
    val totalPages: Int,
    val data: List<UserModel>
)