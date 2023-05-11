package uz.uzapexsoft.cleanarchitecture.presentation.vm

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import uz.uzapexsoft.domain.models.params.LoginParam
import uz.uzapexsoft.domain.usecase.GetAuthUseCase

interface LoginViewModel {
    val resultLiveData: LiveData<Boolean>
    fun login(phoneNumber: String, password: String)
}