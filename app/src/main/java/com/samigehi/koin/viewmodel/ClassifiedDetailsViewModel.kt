package com.samigehi.koin.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.asLiveData
import com.samigehi.core.domain.models.Classified
import com.samigehi.core.usecases.UseCase

class ClassifiedDetailsViewModel(useCase: UseCase) : ViewModel() {

    val list = useCase.getClassifieds().asLiveData()
    val classified : Classified?  = null
}