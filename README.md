# 4-part-CleanArchitecture-MultiModule-Mvvm-Koin
Project: This project is simply a user authorization project". Contained: Recommended app architecture, MultiModule, Mvvm, Koin(Dependency Injection).

> *Siz ko'rib turgan projectim clean architecturaning 4-qismi hisoblanadi. Bosqichma bosqich clean architectura texnologiyalarini qo'lagan holda proektlarni kengaytirmoqdaman. Bu qismda dependency injection uchun Koin frameworkidan foydalnilgan.*

[Koin](https://insert-koin.io/docs/setup/why) har qanday Kotlin applicationga(Multiplatform, Android, Backend ...) dependency injectionning oson va samarali usulini taqdim etadi. Koin - bu Kotlin-ga asoslangan Android applicationlar uchun lightweight dependency injection frameworkidir. U oddiy dependency injectiondan foydalanish va tushunish oson bo'lishi uchun yaratilgan. Koin yordamida dasturchilar o'zlarining dependencylarini va ularning applicationlarga qanday qilib taqdim etilishi kerakligini sodda va o'qilishi oson bo'lgan tarzda amalga oshirishlari mumkin. Koin shuningdek, runtime dependency injectionni qo'llab-quvvatlaydi.
Koin Android hamjamiyatida Dagger kabi dependency injection frameworkiga nisbatan sodda va qulayroq, shu sababli tobora ommalashib bormoqda deb o'ylayman. Bu kichik va o'rta projectlar uchun yaxshi tanlov, va Model-View-ViewModel (MVVM) arxitekturasidan foydalanadigan projectlar uchun juda mos keladi.
Umuman olganda, Koin Kotlin-ga asoslangan Android ilovalaridagi dependencylarni boshqarishning sodda va moslashuvchan usulini taqdim etadi, bu esa dasturchilarga yuqori sifatli projectlarni yaratish va ularga xizmat ko'rsatishni osonlashtiradi.

:relaxed: ***Koin DSL:***
- Koin applicationimizda anotationdan foydlanish yoki kod generatsiya qilish o'rniga, Koin DSL-ni taqdim etadi. Koin o'zining Kotlin DSL bilan dependency injectionni tayyorlash uchun aqlli funktsional APIni taklif qiladi.

:relaxed: ***Application & Module DSL:***

Koin bizga Koin application elementlarini tavsiflash uchun bir nechta kalit so'zlarni taklif qiladi:
- **```Application DSL```** - bu DSL vazifasi Koin container konfiguratsiyasini tavsiflash uchundir.
- **```Module DSL```** - bu DSL vasivasi esa inject qilinishi kerak bo'lgan componentlarni tavsiflash uchundir

***Application DSL***

KoinApplication obyekti Koin container obyekti configuratsiyasidir. Bu bizga logging, properties loading va modullarni sozlash imkonini beradi.
Yangi KoinApplication yaratish uchun bir qancha funksiyalardan foydalanishimiz mumkin: Ulardan proekt shu proektda ishlatgan bir nechtasini ko'rsatib o'taman.
- **```GlobalContext```** - GlobalContext API dan foydalanishga ruxsat beradi.
- **```startKoin {}```** - KoinApplication conteyner konfiguratsiyasini yaratadi va uni ro'yxatdan o'tkazadi.
- **```modules()```** - Conteynerga yuklash uchun Koin modullar ro'yxatini o'rnatadi (list or vararg list).
- **```logger()```** - Logger dasturidan foydalanishni tavsiflaydi, va loggerning qanday darajada ishlashini belgilashimiz mumkin (odatda default EmptyLogger dan foydalaniladi.)

- [] Application DSL dan mana shu proektda qanday foydalanganimni ko'rsatib o'taman:
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
