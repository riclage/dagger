package com.riclage.dagger.example

import android.content.Context
import android.widget.Toast
import javax.inject.Inject

interface MessageHandler {
    fun show(message: String)
}

class AndroidMessageHandler @Inject constructor(private val context: Context) : MessageHandler {
    override fun show(message: String) {
        Toast.makeText(context, message, Toast.LENGTH_SHORT).show()
    }
}