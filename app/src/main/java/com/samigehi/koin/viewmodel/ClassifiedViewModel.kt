package com.samigehi.koin.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.asLiveData
import com.samigehi.core.usecases.UseCase

// or HomeViewModel
class ClassifiedViewModel(useCase: UseCase) : ViewModel() {

    val classified = useCase.getClassifieds().asLiveData()
    val raw = useCase.getClassifieds()
    var isLoading = false

}