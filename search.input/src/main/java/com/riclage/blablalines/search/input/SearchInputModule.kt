package com.riclage.blablalines.search.input

import android.app.Activity
import android.content.Intent
import com.google.android.gms.location.places.ui.PlaceAutocomplete
import dagger.Module
import dagger.Provides

@Module
abstract class SearchInputModule {

    @Module
    companion object {
        @JvmStatic
        @Provides
        fun provideAutocompleteIntent(activity: Activity): Intent {
            return PlaceAutocomplete.IntentBuilder(PlaceAutocomplete.MODE_OVERLAY)
                .build(activity)
        }
    }
}