package uz.uzapexsoft.domain.usecase.impl

import uz.uzapexsoft.domain.models.params.RegistrationParam
import uz.uzapexsoft.domain.repository.AuthRepository
import uz.uzapexsoft.domain.usecase.SaveAuthUseCase
import uz.uzapexsoft.domain.utils.isValidationEmail
import uz.uzapexsoft.domain.utils.isValidationPassword
import uz.uzapexsoft.domain.utils.isValidationPhoneNumber

class SaveAuthUseCaseImpl(private val authRepository: AuthRepository) : SaveAuthUseCase {

    override fun invoke(param: RegistrationParam): Boolean {
        val oldAuthenticationData = authRepository.getAuthentication()

        if (param.email.isValidationEmail() && param.phoneNumber.isValidationPhoneNumber() &&
            param.password.isValidationPassword() && param.password == param.confirmPassword) {
            if (oldAuthenticationData.phoneNumber == param.phoneNumber && oldAuthenticationData.password == param.password)
                return true

            return authRepository.saveAuthentication(saveParam = param)
        }
        return false
    }
}