package com.dev.mvvmsampleapp

import android.app.Application
import com.dev.mvvmsampleapp.data.network.MyApi
import com.dev.mvvmsampleapp.data.network.NetworkConnectionInterceptor
import com.dev.mvvmsampleapp.data.repositories.UserRepository
import com.dev.mvvmsampleapp.ui.auth.AuthViewModelFactory
import com.project.grubbrr.data.AppDatabase
import org.kodein.di.Kodein
import org.kodein.di.KodeinAware
import org.kodein.di.android.x.androidXModule
import org.kodein.di.generic.bind
import org.kodein.di.generic.instance
import org.kodein.di.generic.singleton

class GRUBBRRApplication : Application(), KodeinAware {


    override val kodein = Kodein.lazy {

        import(androidXModule(this@GRUBBRRApplication))

        bind() from singleton { NetworkConnectionInterceptor(instance()) }
        bind() from singleton { MyApi(instance()) }
        bind() from singleton { AppDatabase(instance()) }
        bind() from singleton { UserRepository(instance()) }
        bind() from singleton { AuthViewModelFactory(instance()) }

    }


}