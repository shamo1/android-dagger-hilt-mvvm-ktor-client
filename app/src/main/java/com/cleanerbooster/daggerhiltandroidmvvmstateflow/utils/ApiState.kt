package com.cleanerbooster.daggerhiltandroidmvvmstateflow.utils

import android.content.res.Resources

sealed class ApiState<T>(
 val data: T? = null,
 val message: String? = null
) {
 class Success<T>(data: T) : ApiState<T>(data)
 class Loading<T> : ApiState<T>()
 class Failure<T>(data: T? = null, message: String? = null) : ApiState<T>(data, message)
}