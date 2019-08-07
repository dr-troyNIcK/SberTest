package ru.geekbreins.sbertest.presenter

import ru.geekbreins.sbertest.view.VocabularyItemView

interface IVocabularyRVPresenter {
    fun getVocabularyCount(): Int
    fun bindView(view: VocabularyItemView)
    fun onVocabularyItemViewPushed(position: Int)
}