package com.riclage.dagger.example

import com.riclage.blablalines.search.input.SearchInputFragment
import com.riclage.blablalines.search.input.SearchInputModule
import dagger.Module
import dagger.android.ContributesAndroidInjector

@Module
interface FragmentModule {

    @ContributesAndroidInjector(modules = [SearchInputModule::class])
    fun contributeSearchInputFragment(): SearchInputFragment
}