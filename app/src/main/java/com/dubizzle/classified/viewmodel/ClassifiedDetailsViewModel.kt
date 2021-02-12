package com.dubizzle.classified.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.asLiveData
import com.dubizzle.core.domain.models.Classified
import com.dubizzle.core.usecases.UseCase

class ClassifiedDetailsViewModel(useCase: UseCase) : ViewModel() {

    val list = useCase.getClassifieds().asLiveData()
    val classified : Classified?  = null
}