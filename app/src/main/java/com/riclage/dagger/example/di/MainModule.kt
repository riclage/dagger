package com.riclage.dagger.example.di

import android.app.Activity
import android.content.Context
import com.riclage.dagger.example.AndroidMessageHandler
import com.riclage.dagger.example.MainActivity
import com.riclage.dagger.example.MainApp
import com.riclage.dagger.example.MessageHandler
import dagger.Binds
import dagger.Module
import dagger.android.ContributesAndroidInjector


@Module
interface MainModule {

    @Binds
    fun bindAppContext(mainApp: MainApp): Context

    @Binds
    fun bindMessageHandler(androidMessageHandler: AndroidMessageHandler): MessageHandler

    @Binds
    fun bindActivity(mainActivity: MainActivity): Activity

    @ContributesAndroidInjector(modules = [FragmentModule::class])
    fun contributeMainActivityInjector(): MainActivity

}