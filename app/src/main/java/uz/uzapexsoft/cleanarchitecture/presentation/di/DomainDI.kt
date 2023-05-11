package uz.uzapexsoft.cleanarchitecture.presentation.di

import org.koin.dsl.module
import uz.uzapexsoft.domain.usecase.GetAuthUseCase
import uz.uzapexsoft.domain.usecase.SaveAuthUseCase
import uz.uzapexsoft.domain.usecase.impl.GetAuthUseCaseImpl
import uz.uzapexsoft.domain.usecase.impl.SaveAuthUseCaseImpl

val domainModule = module {
    factory<SaveAuthUseCase> {
        SaveAuthUseCaseImpl(authRepository = get())
    }

    factory<GetAuthUseCase> {
        GetAuthUseCaseImpl(authRepository = get())
    }
}