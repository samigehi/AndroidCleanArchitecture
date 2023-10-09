package com.samigehi.koin.domain.interfaces.usecases

interface DeleteContactUseCase {
    suspend fun delete(id: Int)
}