package uz.uzapexsoft.cleanarchitecture.presentation.vm.impl

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import uz.uzapexsoft.cleanarchitecture.presentation.vm.RegistrationViewModel
import uz.uzapexsoft.domain.models.params.RegistrationParam
import uz.uzapexsoft.domain.usecase.SaveAuthUseCase

class RegistrationViewModelImpl constructor(private val saveAuthUseCase: SaveAuthUseCase) : ViewModel(), RegistrationViewModel {

    private var _resultLiveData = MutableLiveData<Boolean>()
    override val resultLiveData: LiveData<Boolean> get() = _resultLiveData

    override fun registration(email: String, password: String, phoneNumber: String, confirmPassword: String) {
        val registrationParams = RegistrationParam(email = email, password = password, phoneNumber = phoneNumber, confirmPassword = confirmPassword)
        val success = saveAuthUseCase(param = registrationParams)
        _resultLiveData.value = success
    }
}