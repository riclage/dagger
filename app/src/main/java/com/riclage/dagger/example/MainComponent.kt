package com.riclage.dagger.example

import android.content.Context
import dagger.BindsInstance
import dagger.Component
import dagger.android.AndroidInjectionModule

@Component(modules = [MainModule::class, AndroidInjectionModule::class])
interface MainComponent {

    fun inject(mainApp: MainApp)

    @Component.Builder
    interface Builder {
        @BindsInstance
        fun context(context: Context): Builder

        fun build(): MainComponent
    }
}