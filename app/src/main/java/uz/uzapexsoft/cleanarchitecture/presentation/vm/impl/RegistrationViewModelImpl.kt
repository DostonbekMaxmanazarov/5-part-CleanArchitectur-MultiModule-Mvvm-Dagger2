package uz.uzapexsoft.cleanarchitecture.presentation.vm.impl

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import uz.uzapexsoft.domain.models.params.LoginParam
import uz.uzapexsoft.domain.models.params.RegistrationParam
import uz.uzapexsoft.domain.usecase.GetAuthUseCase
import uz.uzapexsoft.domain.usecase.SaveAuthUseCase

class RegistrationViewModel constructor(private val saveAuthUseCase: SaveAuthUseCase) : ViewModel() {

    private var _resultLiveData = MutableLiveData<Boolean>()
    val resultLiveData: LiveData<Boolean> get() = _resultLiveData

    fun registration(email: String, password: String, phoneNumber: String, confirmPassword: String) {
        val registrationParams = RegistrationParam(email = email, password = password, phoneNumber = phoneNumber, confirmPassword = confirmPassword)
        val success = saveAuthUseCase(param = registrationParams)
        _resultLiveData.value = success
    }
}