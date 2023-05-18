package uz.uzapexsoft.cleanarchitecture.presentation.di

import dagger.Component
import uz.uzapexsoft.cleanarchitecture.presentation.fragment.LoginFragment
import uz.uzapexsoft.cleanarchitecture.presentation.fragment.RegistrationFragment

@Component(modules = [ApplicationModule::class, DomainModule::class, DataModule::class])
interface ApplicationComponent {
    fun inject(loginFragment: LoginFragment)
    fun inject(registrationFragment: RegistrationFragment)
}