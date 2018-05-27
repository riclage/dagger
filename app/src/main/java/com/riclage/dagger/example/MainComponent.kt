package com.riclage.dagger.example

import android.content.Context
import dagger.BindsInstance
import dagger.Component
import dagger.android.AndroidInjectionModule
import dagger.android.support.AndroidSupportInjectionModule
import javax.inject.Singleton

@Singleton
@Component(modules = [MainModule::class, AndroidInjectionModule::class, AndroidSupportInjectionModule::class])
interface MainComponent {

    fun inject(mainApp: MainApp)

    @Component.Builder
    interface Builder {
        @BindsInstance
        fun context(context: Context): Builder

        fun build(): MainComponent
    }
}