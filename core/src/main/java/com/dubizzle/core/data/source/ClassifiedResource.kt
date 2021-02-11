package com.dubizzle.core.data.source

sealed class ClassifiedResource<T>(val data: T? = null, val message: String? = null) {
    class Success<T>(data: T) : ClassifiedResource<T>(data)
    class Loading<T>(data: T? = null) : ClassifiedResource<T>(data)
    class Error<T>(message: String, data: T? = null) : ClassifiedResource<T>(data, message)
}