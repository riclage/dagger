package com.riclage.blablalines.search.input

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import dagger.android.AndroidInjection
import javax.inject.Inject
import kotlinx.android.synthetic.main.activity_search_input.*
import com.google.android.gms.location.places.ui.PlaceAutocomplete
import com.google.android.gms.location.places.Place


private const val START_PLACE_AUTOCOMPLETE_REQUEST_CODE = 1
private const val END_PLACE_AUTOCOMPLETE_REQUEST_CODE = 2

class SearchInputActivity : AppCompatActivity() {

    @Inject
    internal lateinit var placeAutocompleteIntent: Intent

    private var startPlace: Place? = null
    private var endPlace: Place? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        AndroidInjection.inject(this)
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_search_input)

        tv_start.setOnClickListener {
            startActivityForResult(placeAutocompleteIntent, START_PLACE_AUTOCOMPLETE_REQUEST_CODE)
        }

        tv_end.setOnClickListener {
            startActivityForResult(placeAutocompleteIntent, END_PLACE_AUTOCOMPLETE_REQUEST_CODE)
        }
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        if (resultCode == Activity.RESULT_OK) {
            val place = PlaceAutocomplete.getPlace(this, data)
            val placeText = place.name
            when (requestCode) {
                START_PLACE_AUTOCOMPLETE_REQUEST_CODE -> {
                    startPlace = place
                    tv_start.text = placeText
                }
                END_PLACE_AUTOCOMPLETE_REQUEST_CODE -> {
                    endPlace = place
                    tv_end.text = placeText
                }
            }
        }
        super.onActivityResult(requestCode, resultCode, data)
    }

}