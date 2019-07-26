package ru.geekbreins.sbertest.presenter

import io.reactivex.Observable

interface ITranslatorFragmentPresenter {
    fun onLanguageOnePushed()
    fun onLanguageTwoPushed()
    fun onReversLanguagePushed()
    fun onInputTextChanged(changedText: Observable<String>)
}