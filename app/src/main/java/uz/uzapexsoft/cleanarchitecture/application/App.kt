package uz.uzapexsoft.cleanarchitecture.application

import android.app.Application
import uz.uzapexsoft.cleanarchitecture.presentation.di.ApplicationComponent
import uz.uzapexsoft.cleanarchitecture.presentation.di.ApplicationModule
import uz.uzapexsoft.cleanarchitecture.presentation.di.DaggerApplicationComponent

class App : Application() {

    lateinit var appComponent: ApplicationComponent

    override fun onCreate() {
        super.onCreate()
        appComponent = DaggerApplicationComponent
            .builder()
            .applicationModule(ApplicationModule(context = this))
            .build()
    }
}