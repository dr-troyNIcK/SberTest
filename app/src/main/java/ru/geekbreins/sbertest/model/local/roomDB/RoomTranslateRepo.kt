package ru.geekbreins.sbertest.model.local.roomDB

import io.reactivex.Single
import io.reactivex.schedulers.Schedulers

class RoomTranslateRepo {
    fun insertTranslateEntity(roomTranslateEntity: RoomTranslateEntity) {
        RoomApplicationDB.getInstance()?.roomTranslateDAO()?.insert(roomTranslateEntity)
    }

    fun getAllTranslateEntities(): Single<List<RoomTranslateEntity>> {
        return Single.create<List<RoomTranslateEntity>> { emitter ->
            RoomApplicationDB.getInstance()?.roomTranslateDAO()?.getAllTranslateEntities()
                ?.let { emitter.onSuccess(it) }
        }.subscribeOn(Schedulers.io())
    }

    fun deleteAllTranslateEntities() {
        RoomApplicationDB.getInstance()?.roomTranslateDAO()?.deleteAllTranslateEntities()
    }
}