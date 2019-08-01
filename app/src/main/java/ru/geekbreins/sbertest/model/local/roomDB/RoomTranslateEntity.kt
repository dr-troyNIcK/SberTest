package ru.geekbreins.sbertest.model.local.roomDB

import android.arch.persistence.room.Entity
import android.arch.persistence.room.PrimaryKey

@Entity
data class RoomTranslateEntity(
    @PrimaryKey
    val textOriginal: String,
    val textTranslation: String,
    val languageOne: String,
    val languageTwo: String
)