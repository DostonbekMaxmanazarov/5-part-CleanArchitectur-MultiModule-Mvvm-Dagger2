package uz.uzapexsoft.cleanarchitecture.presentation.di

import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.bind
import org.koin.dsl.module
import uz.uzapexsoft.cleanarchitecture.presentation.vm.LoginViewModel
import uz.uzapexsoft.cleanarchitecture.presentation.vm.RegistrationViewModel
import uz.uzapexsoft.cleanarchitecture.presentation.vm.impl.LoginViewModelImpl
import uz.uzapexsoft.cleanarchitecture.presentation.vm.impl.RegistrationViewModelImpl

var appModule = module {
    viewModel {
        RegistrationViewModelImpl(saveAuthUseCase = get())
    } bind RegistrationViewModel::class

    viewModel {
        LoginViewModelImpl(getAuthUseCase = get())
    } bind LoginViewModel::class
}