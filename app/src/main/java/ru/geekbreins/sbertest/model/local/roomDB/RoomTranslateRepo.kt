package ru.geekbreins.sbertest.model.local.roomDB

import io.reactivex.Single

class RoomTranslateRepo {
    fun insertTranslateEntity(roomTranslateEntity: RoomTranslateEntity) {
        RoomApplicationDB.getInstance()?.roomTranslateDAO()?.insert(roomTranslateEntity)
    }

    fun getAllTranslateEntities(): List<RoomTranslateEntity> {
        Single.create<String> { }
        return ArrayList<RoomTranslateEntity>()
    }

    fun deleteAllTranslateEntities() {

    }
}