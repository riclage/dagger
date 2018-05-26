package com.riclage.dagger.example

import dagger.Binds
import dagger.Module
import dagger.android.ContributesAndroidInjector


@Module
abstract class MainModule {
    @Binds
    abstract fun messageHandler(androidMessageHandler: AndroidMessageHandler): MessageHandler

    @ContributesAndroidInjector
    abstract fun mainActivityInjector(): MainActivity
}