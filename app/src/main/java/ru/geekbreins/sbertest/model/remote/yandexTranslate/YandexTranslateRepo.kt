package ru.geekbreins.sbertest.model.remote.yandexTranslate

import io.reactivex.Observable
import io.reactivex.schedulers.Schedulers

class YandexTranslateRepo {

    fun getTranslation(text: String, lang: String): Observable<YandexTranslateEntity> {
        return YandexTranslateAPI.create().getTranslation(
            text = text,
            lang = lang
        ).subscribeOn(Schedulers.io())
    }

}