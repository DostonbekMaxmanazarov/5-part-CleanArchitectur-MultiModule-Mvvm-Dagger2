# 4-part-CleanArchitecture-MultiModule-Mvvm-Koin
Project: This project is simply a user authorization project". Contained: Recommended app architecture, MultiModule, Mvvm, Koin(Dependency Injection).

> *Siz ko'rib turgan projectim clean architecturaning 4-qismi hisoblanadi. Bosqichma bosqich clean architectura texnologiyalarini qo'lagan holda proektlarni kengaytirmoqdaman. Bu qismda dependency injection uchun Koin frameworkidan foydalnilgan.*

[Koin](https://insert-koin.io/docs/setup/why) har qanday Kotlin applicationga(Multiplatform, Android, Backend ...) dependency injectionning oson va samarali usulini taqdim etadi. Koin - bu Kotlin-ga asoslangan Android applicationlar uchun lightweight dependency injection frameworkidir. U oddiy dependency injectiondan foydalanish va tushunish oson bo'lishi uchun yaratilgan. Koin yordamida dasturchilar o'zlarining dependencylarini va ularning applicationlarga qanday qilib taqdim etilishi kerakligini sodda va o'qilishi oson bo'lgan tarzda amalga oshirishlari mumkin. Koin shuningdek, runtime dependency injectionni qo'llab-quvvatlaydi.
Koin Android hamjamiyatida Dagger kabi dependency injection frameworkiga nisbatan sodda va qulayroq, shu sababli tobora ommalashib bormoqda deb o'ylayman. Bu kichik va o'rta projectlar uchun yaxshi tanlov, va Model-View-ViewModel (MVVM) arxitekturasidan foydalanadigan projectlar uchun juda mos keladi.
Umuman olganda, Koin Kotlin-ga asoslangan Android ilovalaridagi dependencylarni boshqarishning sodda va moslashuvchan usulini taqdim etadi, bu esa dasturchilarga yuqori sifatli projectlarni yaratish va ularga xizmat ko'rsatishni osonlashtiradi.

**```Koin DSL```**
Koin applicationimizda anotationdan foydlanish yoki kod generatsiya qilish o'rniga, Koin DSL-ni taqdim etadi. Koin o'zining Kotlin DSL bilan dependency injectionni tayyorlash uchun aqlli funktsional APIni taklif qiladi.
