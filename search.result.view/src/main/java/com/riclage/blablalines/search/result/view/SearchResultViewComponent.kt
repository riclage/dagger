package com.riclage.blablalines.search.result.view

import android.content.Context
import com.riclage.blablalines.search.result.provider.SearchResultProviderComponent
import com.riclage.blablalines.search.result.provider.SearchResultProviderComponentHolder
import dagger.Component

@SearchResultViewScope
@Component(dependencies = [SearchResultProviderComponent::class])
interface SearchResultViewComponent {

    @Component.Builder
    interface Builder {
        fun providerComponent(component: SearchResultProviderComponent): Builder
        fun build(): SearchResultViewComponent
    }
}

object SearchResultViewComponentBuilder {

    fun build(context: Context): SearchResultViewComponent {
        return DaggerSearchResultViewComponent
            .builder()
            .providerComponent(SearchResultProviderComponentHolder.get(context))
            .build()
    }

}