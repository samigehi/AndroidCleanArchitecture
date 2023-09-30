package com.samigehi.koin.viewmodel

import androidx.fragment.app.Fragment
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.asLiveData
import com.samigehi.core.usecases.UseCase

// or HomeViewModel
class HomeViewModel(useCase: UseCase) : ViewModel() {

    val classified = useCase.getClassifieds().asLiveData()
    val raw = useCase.getClassifieds()
    var isLoading = false
    private val mPageChange = MutableLiveData<Fragment>()
    val onPageChange: MutableLiveData<Fragment> get() = mPageChange

    fun showFragment(fragment: Fragment){
        mPageChange.postValue(fragment)
    }


}