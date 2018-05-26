package com.riclage.dagger.example

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import javax.inject.Inject

class MainActivity : AppCompatActivity() {

    @Inject
    internal lateinit var messageHandler: MessageHandler

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        DaggerMainComponent.builder()
            .context(this)
            .build()
            .inject(this)

        messageHandler.show("Hello world!")
    }
}
