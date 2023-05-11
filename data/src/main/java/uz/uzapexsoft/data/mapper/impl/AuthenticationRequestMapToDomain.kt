package uz.uzapexsoft.data.mapper.impl

import uz.uzapexsoft.data.mapper.SingleMapper
import uz.uzapexsoft.data.storage.models.AuthenticationRequest
import uz.uzapexsoft.domain.models.Authentication

class AuthenticationRequestMapToDomain : SingleMapper<AuthenticationRequest, Authentication> {
    override fun invoke(value: AuthenticationRequest): Authentication {
        return Authentication(
            password = value.password, phoneNumber = value.phoneNumber
        )
    }
}