[Dagger 2](https://developer.android.com/training/dependency-injection/dagger-basics) - bu Java va Android uchun mashhur dependency injection frameworkidir. Bu bizning ilovangizdagi dependencylarni boshqarishga yordam beradigan, compile time dependency injection frameworki. Dependency Injection - bu ob'ektlarga o'zlarining dependencylarini bevosita qo'lda yaratmasdan dependencylarni tashqaridan  ob'ektlarga taqdim etadi("injected"). Ushbu yondashuv bir xil dependencylarni qayta qayta qo'lda yaratmasdan, faqat bir marta di orqali yaratib foydalanish va kodning testdan o'tkazishiga yordam beradi. Dagger 2 kompilyatsiya jarayonida annotationlar va dependency graph asosida kod yaratish orqali ishlaydi. Dependencylarni provide qilishda yoki inject qilishda Java annotationlardan foydalanadi. Generatsiya qilingan kod dependencylarning obyektlarini yaratadi va boshqaradi.

Dagger 2-dagi ba'zi asosiy tushunchalar:

- **```@Component```** - Dagger 2 bilan ishlash uchun asosiy interfeysdir. U injectionning maqsadlarini belgilaydi va injected qilingan ob'ektlarni ko'rsatadi. Componentlar annotation kod asosida yaratiladi va so'ralganda kerakli dependencylarni ta'minlaydi.
- **```@Module```** - Componentlar tomonidan talab qilinadigan dependencylarni ta'minlovchi class hisoblanadi. Unda ma'lum turdagi obyektlarni qanday yaratish yoki provide qilishni ko'rsatuvchi @Provides bilan annotated qilingang method mavjud. Modullar componentlarga @Component annotatsiyasi yordamida bog'lanadi.
- **```@Inject```** - dependencylarni kiritishni talab qiladigan classdagi construktor, field yoki methodlarni belgilash uchun ishlatiladi. Dagger 2 ushbu annotationni tahlil qiladi va dependencylarni bajarish uchun avtomatik ravishda kodni yaratadi. Va graphdan shu dependencylarni olib keladi, va inject qiladi.
- **```@Scope```** - Dagger 2 dagi scopelar lifecycleni boshqarishga yordam beradi. Scopelar @Scope annotation yordamida aniqlanishi va componentlar yoki individual dependencylarga qo'llanilishi mumkin.



