package ru.geekbreins.sbertest

import android.app.Application
import ru.geekbreins.sbertest.model.local.roomDB.RoomApplicationDB
import timber.log.Timber

class App : Application() {

    companion object {
        lateinit var instance: App
    }

    override fun onCreate() {
        super.onCreate()
        instance = this
        Timber.plant(Timber.DebugTree())
        RoomApplicationDB.create(this)
    }

}