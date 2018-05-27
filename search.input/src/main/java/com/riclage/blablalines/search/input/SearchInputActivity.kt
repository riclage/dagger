package com.riclage.blablalines.search.input

import android.content.Intent
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import dagger.android.AndroidInjection
import javax.inject.Inject

class SearchInputActivity : AppCompatActivity() {

    @Inject
    internal lateinit var placeAutocompleteIntent: Intent

    override fun onCreate(savedInstanceState: Bundle?) {
        AndroidInjection.inject(this)
        super.onCreate(savedInstanceState)
    }

    override fun onStart() {
        super.onStart()
        val PLACE_AUTOCOMPLETE_REQUEST_CODE = 1
        startActivityForResult(placeAutocompleteIntent, PLACE_AUTOCOMPLETE_REQUEST_CODE)
    }
}