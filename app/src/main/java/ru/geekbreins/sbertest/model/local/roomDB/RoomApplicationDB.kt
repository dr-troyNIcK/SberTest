package ru.geekbreins.sbertest.model.local.roomDB

import android.arch.persistence.room.Database
import android.arch.persistence.room.Room
import android.arch.persistence.room.RoomDatabase
import android.content.Context

@Database(entities = [RoomTranslateEntity::class], version = 1)
abstract class RoomApplicationDB : RoomDatabase() {

    abstract fun roomTranslateDAO(): RoomTranslateDAO

    companion object {
        @Volatile
        private var instance: RoomApplicationDB? = null

        @Synchronized
        fun create(context: Context): RoomApplicationDB? {
            if (instance == null) {
                instance = Room.databaseBuilder<RoomApplicationDB>(
                    context,
                    RoomApplicationDB::class.java,
                    "RoomApplicationDB.db"
                ).build()
            }
            return instance
        }

    }

}