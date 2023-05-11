package uz.uzapexsoft.cleanarchitecture.presentation.vm

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import uz.uzapexsoft.domain.models.params.LoginParam
import uz.uzapexsoft.domain.models.params.RegistrationParam
import uz.uzapexsoft.domain.usecase.GetAuthUseCase
import uz.uzapexsoft.domain.usecase.SaveAuthUseCase

interface RegistrationViewModel {
    val resultLiveData: LiveData<Boolean>
    fun registration(email: String, password: String, phoneNumber: String, confirmPassword: String)
}