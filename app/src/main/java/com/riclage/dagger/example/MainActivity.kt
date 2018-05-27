package com.riclage.dagger.example

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v4.app.Fragment
import com.riclage.blablalines.search.input.SearchInputFragment
import dagger.android.AndroidInjection
import dagger.android.AndroidInjector
import dagger.android.support.HasSupportFragmentInjector
import javax.inject.Inject
import dagger.android.DispatchingAndroidInjector

class MainActivity : AppCompatActivity(), HasSupportFragmentInjector {

    @Inject
    internal lateinit var fragmentDispatchingAndroidInjector: DispatchingAndroidInjector<Fragment>

    @Inject
    internal lateinit var messageHandler: MessageHandler

    override fun onCreate(savedInstanceState: Bundle?) {
        AndroidInjection.inject(this)
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        messageHandler.show("Hello world!")

        if (savedInstanceState == null) {
            supportFragmentManager.beginTransaction()
                .add(R.id.fragment_container, SearchInputFragment())
                .commit()
        }
    }

    override fun supportFragmentInjector(): AndroidInjector<Fragment> {
        return fragmentDispatchingAndroidInjector
    }
}
