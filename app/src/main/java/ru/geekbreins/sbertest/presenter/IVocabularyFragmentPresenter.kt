package ru.geekbreins.sbertest.presenter

import io.reactivex.Observable

interface IVocabularyFragmentPresenter {
    fun onClearListPushed()
    fun onSearchTextChanged(changedText: Observable<String>)
}