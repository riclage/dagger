package com.riclage.dagger.example.di

import com.riclage.common.ServiceCreator
import dagger.Module
import dagger.Provides
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory
import javax.inject.Singleton

@Module
object NetModule {

    @JvmStatic
    @Singleton
    @Provides
    fun provideServiceCreator(): ServiceCreator {
        val retrofit = Retrofit.Builder()
            .baseUrl("https://api.example.com")
            .addConverterFactory(MoshiConverterFactory.create())
            .build()

        return object : ServiceCreator {
            override fun <T> create(javaClass: Class<T>): T {
                return retrofit.create(javaClass)
            }
        }
    }
}