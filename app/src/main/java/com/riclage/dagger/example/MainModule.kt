package com.riclage.dagger.example

import android.app.Activity
import dagger.Binds
import dagger.Module
import dagger.android.ContributesAndroidInjector


@Module
interface MainModule {
    @Binds
    fun bindMessageHandler(androidMessageHandler: AndroidMessageHandler): MessageHandler

    @Binds
    fun bindActivity(mainActivity: MainActivity): Activity

    @ContributesAndroidInjector(modules = [FragmentModule::class])
    fun contributeMainActivityInjector(): MainActivity

}