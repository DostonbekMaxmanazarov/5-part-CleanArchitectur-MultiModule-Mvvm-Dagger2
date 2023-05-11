package uz.uzapexsoft.cleanarchitecture.presentation.vm.impl

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import uz.uzapexsoft.cleanarchitecture.presentation.vm.LoginViewModel
import uz.uzapexsoft.domain.models.params.LoginParam
import uz.uzapexsoft.domain.usecase.GetAuthUseCase

class LoginViewModelImpl constructor(private val getAuthUseCase: GetAuthUseCase) : ViewModel(), LoginViewModel {

    private var _resultLiveData = MutableLiveData<Boolean>()
    override val resultLiveData: LiveData<Boolean> get() = _resultLiveData

    override fun login(phoneNumber: String, password: String) {
        val loginParam = LoginParam(phoneNumber = phoneNumber, password = password)
        val success = getAuthUseCase(param = loginParam)
        _resultLiveData.value = success
    }
}