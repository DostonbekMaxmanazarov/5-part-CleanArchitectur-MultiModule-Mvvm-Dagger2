package uz.uzapexsoft.data.storage.impl

import android.content.Context
import uz.uzapexsoft.data.storage.AuthStorageSharedPref
import uz.uzapexsoft.data.models.AuthenticationRequest
import uz.uzapexsoft.data.utils.ConstantsData.DEFAULT_EMAIL
import uz.uzapexsoft.data.utils.ConstantsData.DEFAULT_PASSWORD
import uz.uzapexsoft.data.utils.ConstantsData.DEFAULT_PHONE_NUMBER
import uz.uzapexsoft.data.utils.ConstantsData.EMAIL
import uz.uzapexsoft.data.utils.ConstantsData.PASSWORD
import uz.uzapexsoft.data.utils.ConstantsData.PHONE_NUMBER
import uz.uzapexsoft.data.utils.ConstantsData.SHARED_PREFS_NAME

class AuthStorageSharedPrefImpl(context: Context) : AuthStorageSharedPref {
    private val sharedPreference = context.getSharedPreferences(SHARED_PREFS_NAME, Context.MODE_PRIVATE)

    override fun saveAuthentication(user: AuthenticationRequest): Boolean {
        sharedPreference.edit().putString(EMAIL, user.email).apply()
        sharedPreference.edit().putString(PASSWORD, user.password).apply()
        sharedPreference.edit().putString(PHONE_NUMBER, user.phoneNumber).apply()
        return true
    }

    override fun getAuthentication(): AuthenticationRequest {
        val email = sharedPreference.getString(EMAIL, DEFAULT_EMAIL) ?: DEFAULT_EMAIL
        val password = sharedPreference.getString(PASSWORD, DEFAULT_PASSWORD) ?: DEFAULT_PASSWORD
        val phoneNumber = sharedPreference.getString(PHONE_NUMBER, DEFAULT_PHONE_NUMBER) ?: DEFAULT_PHONE_NUMBER

        return AuthenticationRequest(email = email, password = password, phoneNumber = phoneNumber)
    }
}