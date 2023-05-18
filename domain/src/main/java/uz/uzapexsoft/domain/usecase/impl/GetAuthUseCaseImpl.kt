package uz.uzapexsoft.domain.usecase.impl

import uz.uzapexsoft.domain.models.params.LoginParam
import uz.uzapexsoft.domain.repository.AuthRepository
import uz.uzapexsoft.domain.usecase.GetAuthUseCase

class GetAuthUseCaseImpl(private val authRepository: AuthRepository) : GetAuthUseCase {

    override fun invoke(param: LoginParam): Boolean {
        val authentication = authRepository.getAuthentication()
        if (param.password == authentication.password && param.phoneNumber == authentication.phoneNumber)
            return true
        return false
    }
}