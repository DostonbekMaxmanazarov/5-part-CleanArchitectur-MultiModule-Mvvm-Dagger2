package uz.uzapexsoft.data.storage

import uz.uzapexsoft.data.storage.models.AuthenticationRequest

interface AuthStorage {
    fun getAuthentication(): AuthenticationRequest
    fun saveAuthentication(user: AuthenticationRequest): Boolean
}