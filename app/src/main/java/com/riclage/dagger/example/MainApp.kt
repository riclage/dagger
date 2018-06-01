package com.riclage.dagger.example

import android.app.Activity
import android.app.Application
import com.riclage.common.ComponentFinder
import com.riclage.dagger.example.di.DaggerMainComponent
import dagger.android.AndroidInjector
import dagger.android.HasActivityInjector
import dagger.android.DispatchingAndroidInjector
import javax.inject.Inject


class MainApp : Application(), HasActivityInjector {

    private val component by lazy {
        DaggerMainComponent.builder()
            .app(this)
            .build()
    }

    @Inject
    internal lateinit var dispatchingActivityInjector: DispatchingAndroidInjector<Activity>

    override fun onCreate() {
        super.onCreate()
        component.inject(this)
    }

    override fun getSystemService(name: String): Any {
        if (ComponentFinder.isComponentFinderService(name)) {
            return component
        }
        return super.getSystemService(name)
    }

    override fun activityInjector(): AndroidInjector<Activity> {
        return dispatchingActivityInjector
    }

}