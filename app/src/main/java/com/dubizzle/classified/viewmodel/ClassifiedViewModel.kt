package com.dubizzle.classified.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.asLiveData
import com.dubizzle.core.usecases.UseCase

class ClassifiedViewModel(useCase: UseCase) : ViewModel() {

    val classified = useCase.getClassifieds().asLiveData()
    val raw = useCase.getClassifieds()
}