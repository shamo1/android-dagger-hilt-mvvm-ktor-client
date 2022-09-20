package com.cleanerbooster.daggerhiltandroidmvvmstateflow.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.cleanerbooster.daggerhiltandroidmvvmstateflow.network.respose.PostResponseItem
import com.cleanerbooster.daggerhiltandroidmvvmstateflow.repositories.PostsRepository
import com.cleanerbooster.daggerhiltandroidmvvmstateflow.utils.ApiState
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.*
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class PostViewModel @Inject constructor(val postsRepository: PostsRepository) : ViewModel()  {

    val _postStateFloe : MutableStateFlow<ApiState<ArrayList<PostResponseItem>>> = MutableStateFlow(ApiState.Loading())
    val state : StateFlow<ApiState<ArrayList<PostResponseItem>>>   = _postStateFloe

    fun getPost() = viewModelScope.launch {
        postsRepository.getPost().onStart {
            _postStateFloe.value = ApiState.Loading()
        }.catch {e->
            _postStateFloe.value = ApiState.Failure(null,e.message)
        }.collect {response->
            _postStateFloe.value = ApiState.Success(response)
        }
    }

}