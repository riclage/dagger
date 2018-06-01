package com.riclage.common

import android.annotation.SuppressLint
import android.content.Context

const val INJECTOR_SERVICE = "com.comuto.squirrel.injector_service"

object ComponentFinder {

    @SuppressLint("WrongConstant")
    fun <T> find(context: Context): T {
        return context.getSystemService(INJECTOR_SERVICE) as T
    }

    fun isComponentFinderService(service: String): Boolean {
        return INJECTOR_SERVICE == service
    }
}