package ru.geekbreins.sbertest.model.repos

import java.util.*

class LanguagesRepo private constructor() {
    val languages: ArrayList<String>? = ArrayList(Arrays.asList("Русский", "English", "العربية"))
    var languagesKeys: ArrayList<String>? = ArrayList(Arrays.asList("ru", "en", "ar"))

    companion object {
        val instance = LanguagesRepo()
    }
}
