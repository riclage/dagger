package com.riclage.blablalines.search.result.provider

import android.content.Context
import com.riclage.common.ComponentFinder
import com.riclage.common.HasServiceCreator
import com.riclage.common.ServiceCreator
import dagger.BindsInstance
import dagger.Component
import dagger.Module
import dagger.Provides

@SearchResultProviderScope
@Component(modules = [SearchResultProviderModule::class])
interface SearchResultProviderComponent {

    @Component.Builder
    interface Builder {
        @BindsInstance
        fun serviceCreator(serviceCreator: ServiceCreator): Builder

        fun build(): SearchResultProviderComponent
    }
}

@Module
object SearchResultProviderModule {

    @JvmStatic
    @Provides
    @SearchResultProviderScope
    fun provideSearchResultProvider(serviceCreator: ServiceCreator): SearchResultProvider {
        return serviceCreator.create(SearchResultProvider::class.java)
    }
}

object SearchResultProviderComponentHolder {

    private lateinit var component: SearchResultProviderComponent

    fun get(context: Context): SearchResultProviderComponent {
        if (!::component.isInitialized) {
            val hasServiceCreator = ComponentFinder.find<HasServiceCreator>(context.applicationContext)
            component = DaggerSearchResultProviderComponent
                .builder()
                .serviceCreator(hasServiceCreator.serviceCreator())
                .build()

        }
        return component
    }
}