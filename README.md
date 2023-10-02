# AndroidCleanArchitecture

Android Clean Architecture sample with Koin Dependencies Injection, Coroutine, Jetpack components with moduler approach (I create a Module 'Core' which contains Data and Domain Layers - we can also add Data/Domain layers in 'App' Module).

A simple app which fetch some data from back-end endpoint with a GET request and display a list using RecyclerView and using automated tests like Unit Test, Integration/UI Test.

Libraries Used in this project

    Kotlin Coroutine  
    Okhttp
    Retrofit
    Koin (for DI)
    Glide
    Google Architecture Components (ViewModel, LiveData, AndroidX, Material)
    Android Clean Architecture 


In most of the projects I used Dagger2 and Hilt, In this sample I tried to explore 'Koin' dependencies injecttion with Kotlin Coroutines - Koin uses the power of 'Kotlin Reified' to create dependencies while Dagger/Hilt uses annotation processing to create dependencies.

This is not fully functional app, this is just for demo purpose that how we can use Koin DI with Jetpack components and Coroutine.

