package uz.uzapexsoft.data.storage

import uz.uzapexsoft.data.models.AuthenticationRequest

interface AuthStorageSharedPref {
    fun getAuthentication(): AuthenticationRequest
    fun saveAuthentication(user: AuthenticationRequest): Boolean
}