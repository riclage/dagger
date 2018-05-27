package com.riclage.dagger.example

import com.riclage.blablalines.search.input.SearchInputActivity
import com.riclage.blablalines.search.input.SearchInputModule
import dagger.Binds
import dagger.Module
import dagger.android.ContributesAndroidInjector


@Module
interface MainModule {
    @Binds
    fun messageHandler(androidMessageHandler: AndroidMessageHandler): MessageHandler

    @ContributesAndroidInjector
    fun mainActivityInjector(): MainActivity

    @ContributesAndroidInjector(modules = [SearchInputModule::class])
    fun searchInputActivityInjector(): SearchInputActivity
}