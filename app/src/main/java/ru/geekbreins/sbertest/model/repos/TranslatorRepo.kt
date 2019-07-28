package ru.geekbreins.sbertest.model.repos

import io.reactivex.Observable
import io.reactivex.schedulers.Schedulers
import ru.geekbreins.sbertest.model.api.YandexTranslatorAPI
import ru.geekbreins.sbertest.model.entities.Translation

class TranslatorRepo {

    fun getTranslation(text: String, lang: String): Observable<Translation> {
        return YandexTranslatorAPI.create().getTranslation(
            text = text,
            lang = lang
        ).subscribeOn(Schedulers.io())
    }

}