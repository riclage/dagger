package com.riclage.dagger.example

import android.app.Activity
import dagger.Binds
import dagger.Module
import dagger.Provides
import dagger.android.ContributesAndroidInjector
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory
import javax.inject.Singleton


@Module
interface MainModule {

    @Singleton
    @Provides
    fun provideRetrofit(): Retrofit {
        return Retrofit.Builder()
            .baseUrl("https://api.example.com")
            .addConverterFactory(MoshiConverterFactory.create())
            .build()
    }

    @Binds
    fun bindMessageHandler(androidMessageHandler: AndroidMessageHandler): MessageHandler

    @Binds
    fun bindActivity(mainActivity: MainActivity): Activity

    @ContributesAndroidInjector(modules = [FragmentModule::class])
    fun contributeMainActivityInjector(): MainActivity

}