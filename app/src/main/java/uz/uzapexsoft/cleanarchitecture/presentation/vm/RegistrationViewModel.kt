package uz.uzapexsoft.cleanarchitecture.presentation.vm

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import uz.uzapexsoft.domain.models.params.RegistrationParam
import uz.uzapexsoft.domain.usecase.SaveAuthUseCase
import javax.inject.Inject

class RegistrationViewModel @Inject constructor(
    private val saveAuthUseCase: SaveAuthUseCase
) : ViewModel() {

    private var _resultLiveData = MutableLiveData<Boolean>()
    val resultLiveData: LiveData<Boolean> get() = _resultLiveData

    fun registration(email: String, password: String, phoneNumber: String, confirmPassword: String) {
        val registrationParams = RegistrationParam(email = email, password = password, phoneNumber = phoneNumber, confirmPassword = confirmPassword)
        val success = saveAuthUseCase(param = registrationParams)
        _resultLiveData.value = success
    }
}