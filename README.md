# 4-part-CleanArchitecture-MultiModule-Mvvm-Koin
Project: This project is simply a user authorization project". Contained: Recommended app architecture, MultiModule, Mvvm, Koin(Dependency Injection).

> *Siz ko'rib turgan projectim clean architecturaning 4-qismi hisoblanadi. Bosqichma bosqich clean architectura texnologiyalarini qo'lagan holda proektlarni kengaytirmoqdaman. Bu qismda dependency injection uchun Koin frameworkidan foydalnilgan.*

[Koin](https://insert-koin.io/docs/setup/why) har qanday Kotlin applicationga(Multiplatform, Android, Backend ...) dependency injectionning oson va samarali usulini taqdim etadi. Koin - bu Kotlin-ga asoslangan Android applicationlar uchun lightweight dependency injection frameworkidir. U oddiy dependency injectiondan foydalanish va tushunish oson bo'lishi uchun yaratilgan. Koin yordamida dasturchilar o'zlarining dependencylarini va ularning applicationlarga qanday qilib taqdim etilishi kerakligini sodda va o'qilishi oson bo'lgan tarzda amalga oshirishlari mumkin. Koin shuningdek, runtime dependency injectionni qo'llab-quvvatlaydi.
Koin Android hamjamiyatida Dagger kabi dependency injection frameworkiga nisbatan sodda va qulayroq, shu sababli tobora ommalashib bormoqda deb o'ylayman. Bu kichik va o'rta projectlar uchun yaxshi tanlov, va Model-View-ViewModel (MVVM) arxitekturasidan foydalanadigan projectlar uchun juda mos keladi.
Umuman olganda, Koin Kotlin-ga asoslangan Android ilovalaridagi dependencylarni boshqarishning sodda va moslashuvchan usulini taqdim etadi, bu esa dasturchilarga yuqori sifatli projectlarni yaratish va ularga xizmat ko'rsatishni osonlashtiradi.

:green_circle: ***Koin DSL:***
- Koin applicationimizda anotationdan foydlanish yoki kod generatsiya qilish o'rniga, Koin DSL-ni taqdim etadi. Koin o'zining Kotlin DSL bilan dependency injectionni tayyorlash uchun aqlli funktsional APIni taklif qiladi.

:green_circle: ***Application & Module DSL:***

Koin bizga Koin application elementlarini tavsiflash uchun bir nechta kalit so'zlarni taklif qiladi:
- **```Application DSL```** - to describe the Koin container configuration.
- **```Module DSL```** - to describe the components that have to be injected.

:green_circle: ***Application DSL***

KoinApplication obyekti Koin container obyekti configuratsiyasidir. Bu bizga logging, properties loading va modullarni sozlash imkonini beradi.
Yangi KoinApplication yaratish uchun bir qancha funksiyalardan foydalanishimiz mumkin: Ulardan proekt shu proektda ishlatgan bir nechtasini ko'rsatib o'taman.
- **```GlobalContext```** - to allow the use of GlobalContext API.
- **```startKoin {}```** - create a KoinApplication container configuration and register it in the.
- **```modules()```** - set a list of Koin modules to load in the container (list or vararg list).
- **```logger()```** - describe what level and Logger implementation to use (by default use the EmptyLogger)

:white_check_mark: Application DSL dan mana shu proektda qanday foydalanganimni ko'rsatib o'taman:
```kotlin 
class App : Application() {
    override fun onCreate() {
        super.onCreate()
        startKoin {
            androidLogger(Level.DEBUG)
            androidContext(this@App)
            modules(listOf(appModule, domainModule, dataModule))
        }
    }
}
```
:green_circle: ***Module DSL:***

Koin moduli applicationimiz uchun inject qilinadigan modullarni to'playdi. Yangi modul yaratish uchun quyidagi funksiyalardan foydalanishimiz mumkin:

- **``` module {}```** - create a Koin Module.
- **``` factory {}```** - provide a factory bean definition
- **``` single {}```** - provide a singleton bean definition (also aliased as bean)
- **``` get ()```** - resolve a component dependency (also can use name, scope or parameters)
- **``` bind ()```** - add type to bind for given bean definition

:white_check_mark: Module DSL dan proektimda qanday foydalanganimni ko'rsatib o'taman: Bunda modullarimni 3 qismga bo'lib olganman, **```ApplicationModule```**, **```DataModule```**, **```DomainModule```***.
- Application module:
```kotlin 
var appModule = module {
    viewModel {
        RegistrationViewModelImpl(saveAuthUseCase = get())
    } bind RegistrationViewModel::class

    viewModel {
        LoginViewModelImpl(getAuthUseCase = get())
    } bind LoginViewModel::class
}
```
- Domain module:
```kotlin
val domainModule = module {
    factory<SaveAuthUseCase> {
        SaveAuthUseCaseImpl(authRepository = get())
    }

    factory<GetAuthUseCase> {
        GetAuthUseCaseImpl(authRepository = get())
    }
}
```
- Data module
```kotlin 
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
```



