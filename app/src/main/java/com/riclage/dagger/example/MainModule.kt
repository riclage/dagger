package com.riclage.dagger.example

import dagger.Binds
import dagger.Module

@Module
abstract class MainModule {
    @Binds
    abstract fun messageHandler(androidMessageHandler: AndroidMessageHandler): MessageHandler
}