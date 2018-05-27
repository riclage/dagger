package com.riclage.blablalines.search.input

import android.app.Activity
import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import javax.inject.Inject
import kotlinx.android.synthetic.main.fragment_search_input.*
import com.google.android.gms.location.places.ui.PlaceAutocomplete
import com.google.android.gms.location.places.Place
import dagger.android.support.AndroidSupportInjection


private const val START_PLACE_AUTOCOMPLETE_REQUEST_CODE = 1
private const val END_PLACE_AUTOCOMPLETE_REQUEST_CODE = 2

class SearchInputFragment : Fragment() {

    @Inject
    internal lateinit var placeAutocompleteIntent: Intent

    private var startPlace: Place? = null
    private var endPlace: Place? = null

    override fun onAttach(context: Context?) {
        AndroidSupportInjection.inject(this)
        super.onAttach(context)
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.fragment_search_input, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        tv_start.setOnClickListener {
            startActivityForResult(placeAutocompleteIntent, START_PLACE_AUTOCOMPLETE_REQUEST_CODE)
        }

        tv_end.setOnClickListener {
            startActivityForResult(placeAutocompleteIntent, END_PLACE_AUTOCOMPLETE_REQUEST_CODE)
        }
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        if (resultCode == Activity.RESULT_OK) {
            val place = PlaceAutocomplete.getPlace(requireContext(), data)
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
        } else {
            super.onActivityResult(requestCode, resultCode, data)
        }
    }

}