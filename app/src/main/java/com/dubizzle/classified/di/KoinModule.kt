package com.dubizzle.classified.di

import com.dubizzle.classified.viewmodel.ClassifiedDetailsViewModel
import com.dubizzle.classified.viewmodel.ClassifiedViewModel
import com.dubizzle.core.usecases.UseCaseImpl
import com.dubizzle.core.usecases.UseCase
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.FlowPreview
import org.koin.android.viewmodel.dsl.viewModel
import org.koin.dsl.module


val useCaseModule = module {
    factory<UseCase> { UseCaseImpl(get()) }
}

@ExperimentalCoroutinesApi
@FlowPreview
val viewModelModule = module {
    viewModel { ClassifiedViewModel(get()) }
    viewModel { ClassifiedDetailsViewModel(get()) }
}