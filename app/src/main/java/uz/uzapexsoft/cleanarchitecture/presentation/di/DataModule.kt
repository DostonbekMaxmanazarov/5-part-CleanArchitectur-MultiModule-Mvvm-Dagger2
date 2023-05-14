package uz.uzapexsoft.cleanarchitecture.presentation.di

import org.koin.core.qualifier.named
import org.koin.dsl.module
import uz.uzapexsoft.data.mapper.SingleMapper
import uz.uzapexsoft.data.mapper.impl.AuthenticationRequestMapToDomain
import uz.uzapexsoft.data.mapper.impl.SaveAuthenticationParamMapToStorage
import uz.uzapexsoft.data.repository.AuthRepositoryImpl
import uz.uzapexsoft.data.storage.AuthStorage
import uz.uzapexsoft.data.storage.impl.AuthStorageSharedPrefImpl
import uz.uzapexsoft.data.storage.models.AuthenticationRequest
import uz.uzapexsoft.domain.models.Authentication
import uz.uzapexsoft.domain.models.params.RegistrationParam
import uz.uzapexsoft.domain.repository.AuthRepository

private const val MAP_TO_STORAGE_NAMED = "MapToStorage"
private const val MAP_TO_DOMAIN_NAMED = "MapToDomain"

val dataModule = module {

    single<SingleMapper<RegistrationParam, AuthenticationRequest>>(named(MAP_TO_STORAGE_NAMED)) {
        SaveAuthenticationParamMapToStorage()
    }

    single<SingleMapper<AuthenticationRequest, Authentication>>(named(MAP_TO_DOMAIN_NAMED)) {
        AuthenticationRequestMapToDomain()
    }

    single<AuthStorage> {
        AuthStorageSharedPrefImpl(context = get())
    }


    single<AuthRepository> {
        AuthRepositoryImpl(authStorage = get(), authRequestMapToDomain = get(qualifier = named(MAP_TO_DOMAIN_NAMED)), saveAuthParamMapToStorage = get(qualifier = named(MAP_TO_STORAGE_NAMED)))
    }
}

