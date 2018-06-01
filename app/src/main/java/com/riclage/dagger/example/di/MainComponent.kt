package com.riclage.dagger.example.di

import com.riclage.common.HasServiceCreator
import com.riclage.dagger.example.MainApp
import dagger.BindsInstance
import dagger.Component
import dagger.android.AndroidInjectionModule
import dagger.android.support.AndroidSupportInjectionModule
import javax.inject.Singleton

@Singleton
@Component(modules = [
    MainModule::class, NetModule::class, AndroidInjectionModule::class, AndroidSupportInjectionModule::class
])
interface MainComponent : HasServiceCreator {

    fun inject(mainApp: MainApp)

    @Component.Builder
    interface Builder {
        @BindsInstance
        fun app(mainApp: MainApp): Builder

        fun build(): MainComponent
    }
}