package ru.geekbreins.sbertest.model.local.roomDB

import io.reactivex.Completable
import io.reactivex.Single
import io.reactivex.schedulers.Schedulers

class RoomTranslateRepo {
    fun insertTranslateEntity(roomTranslateEntity: RoomTranslateEntity) {
        Completable.fromAction {
            RoomApplicationDB.getInstance()?.roomTranslateDAO()?.insert(roomTranslateEntity)
        }.subscribeOn(Schedulers.io()).subscribe()
    }

    fun getAllTranslateEntities(): Single<List<RoomTranslateEntity>> {
        return Single.create<List<RoomTranslateEntity>> { emitter ->
            RoomApplicationDB.getInstance()?.roomTranslateDAO()?.getAllTranslateEntities()
                ?.let { emitter.onSuccess(it) }
        }.subscribeOn(Schedulers.io())
    }

    fun deleteAllTranslateEntities() {
        Completable.fromAction {
            RoomApplicationDB.getInstance()?.roomTranslateDAO()?.deleteAllTranslateEntities()
        }.subscribeOn(Schedulers.io()).subscribe()

    }
}