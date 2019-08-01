package ru.geekbreins.sbertest.presenter

import io.reactivex.Observable

interface ITranslateFragmentPresenter {
    fun onLanguageOnePushed()
    fun onLanguageTwoPushed()
    fun onReversLanguagePushed()
    fun subscribeOnTextChange(changedText: Observable<CharSequence>)
}