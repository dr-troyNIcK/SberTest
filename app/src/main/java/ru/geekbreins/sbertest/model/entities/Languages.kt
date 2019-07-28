package ru.geekbreins.sbertest.model.entities

import java.util.*

class Languages private constructor() {
    var languages: ArrayList<String>? = null
    var languagesKeys: ArrayList<String>? = null

    init {
        languages = ArrayList(Arrays.asList("Русский", "English", "العربية"))
        languagesKeys = ArrayList(Arrays.asList("ru", "en", "ar"))
    }

    companion object {
        val instance = Languages()
    }
}
