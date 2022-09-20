package com.cleanerbooster.daggerhiltandroidmvvmstateflow.repositories

import com.cleanerbooster.daggerhiltandroidmvvmstateflow.network.networkService.ApiService
import com.cleanerbooster.daggerhiltandroidmvvmstateflow.network.respose.PostResponseItem
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn
import java.util.ArrayList
import java.util.concurrent.Flow
import javax.inject.Inject

class PostsRepository @Inject constructor(val apiService: ApiService)  {

    fun getPost() : kotlinx.coroutines.flow.Flow<ArrayList<PostResponseItem>> = flow {
        emit(apiService.getPost())
    }.flowOn(Dispatchers.IO)

}