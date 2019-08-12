package ru.geekbreins.sbertest.model.local

import java.util.*

class LanguagesRepo private constructor() {
    @Volatile
    var languageOneState: Int = 1
    @Volatile
    var languageTwoState: Int = 0

    @Volatile
    var inputTextState: String = ""
    @Volatile
    var outputTextState: String = ""

    val languages: ArrayList<String> = ArrayList(Arrays.asList("Русский", "English", "العربية"))
    val languagesKeys: ArrayList<String> = ArrayList(Arrays.asList("ru", "en", "ar"))

    companion object {
        private val instance = LanguagesRepo()

        @Synchronized
        fun getInstance(): LanguagesRepo {
            return instance
        }
    }
}
