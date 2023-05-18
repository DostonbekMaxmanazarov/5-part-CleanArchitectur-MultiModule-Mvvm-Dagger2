package uz.uzapexsoft.cleanarchitecture.presentation.di

import android.content.Context
import dagger.Module
import dagger.Provides
import uz.uzapexsoft.data.mapper.SingleMapper
import uz.uzapexsoft.data.mapper.impl.AuthenticationRequestMapToDomain
import uz.uzapexsoft.data.mapper.impl.SaveAuthenticationParamMapToStorage
import uz.uzapexsoft.data.models.AuthenticationRequest
import uz.uzapexsoft.data.repository.AuthRepositoryImpl
import uz.uzapexsoft.data.storage.AuthStorageSharedPref
import uz.uzapexsoft.data.storage.impl.AuthStorageSharedPrefImpl
import uz.uzapexsoft.domain.models.Authentication
import uz.uzapexsoft.domain.models.params.RegistrationParam
import uz.uzapexsoft.domain.repository.AuthRepository

@Module
class DataModule {

    @Provides
    fun provideAuthStorage(context: Context): AuthStorageSharedPref =
            AuthStorageSharedPrefImpl(context = context)

    @Provides
    fun providesSaveAuthParamMapToStorage(): SingleMapper<RegistrationParam, AuthenticationRequest> =
            SaveAuthenticationParamMapToStorage()

    @Provides
    fun provideAuthRequestMapToDomain(): SingleMapper<AuthenticationRequest, Authentication> =
            AuthenticationRequestMapToDomain()

    @Provides
    fun provideAuthRepository(
        authStorage: AuthStorageSharedPref,
        authRequestMapToDomain: SingleMapper<AuthenticationRequest, Authentication>,
        saveAuthParamMapToStorage: SingleMapper<RegistrationParam, AuthenticationRequest>
    ): AuthRepository = AuthRepositoryImpl(
            authStorage = authStorage,
            authRequestMapToDomain = authRequestMapToDomain,
            saveAuthParamMapToStorage = saveAuthParamMapToStorage
    )

}
