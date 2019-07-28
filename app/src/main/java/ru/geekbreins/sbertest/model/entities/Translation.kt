package ru.geekbreins.sbertest.model.entities

import com.google.gson.annotations.Expose

data class Translation(
    @Expose
    val lang: String,
    @Expose
    val text: Array<String>
)