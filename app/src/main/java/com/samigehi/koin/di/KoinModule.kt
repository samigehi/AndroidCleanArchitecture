package com.samigehi.koin.di

import com.samigehi.koin.viewmodel.ClassifiedDetailsViewModel
import com.samigehi.koin.viewmodel.ClassifiedViewModel
import com.samigehi.core.usecases.UseCaseImpl
import com.samigehi.core.usecases.UseCase
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