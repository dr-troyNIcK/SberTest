package ru.geekbreins.sbertest.model.remote.yandexTranslate

import com.google.gson.FieldNamingPolicy
import com.google.gson.GsonBuilder
import io.reactivex.Observable
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET
import retrofit2.http.Query

interface YandexTranslateAPI {
    @GET("translate")
    fun getTranslation(
        @Query("key") key: String = "trnsl.1.1.20190727T114009Z.6bfbe740c373fb11.272de982f42d65b1018d9e1f5d272424ea5f8020",
        @Query("text") text: String,
        @Query("lang") lang: String
    ): Observable<YandexTranslateEntity>

    companion object Factory {
        fun create(): YandexTranslateAPI {
            return Retrofit.Builder()
                .baseUrl("https://translate.yandex.net/api/v1.5/tr.json/")
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .addConverterFactory(
                    GsonConverterFactory.create(
                        GsonBuilder()
                            .setFieldNamingPolicy(FieldNamingPolicy.LOWER_CASE_WITH_UNDERSCORES).create()
                    )
                )
                .build()
                .create(YandexTranslateAPI::class.java)
        }
    }
}