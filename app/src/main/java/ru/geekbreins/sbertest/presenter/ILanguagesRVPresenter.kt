package ru.geekbreins.sbertest.presenter

import ru.geekbreins.sbertest.view.LanguagesItemView

interface ILanguagesRVPresenter {
    fun getLanguagesCount(): Int
    fun bindView(view: LanguagesItemView)
    fun onLanguageItemViewPushed(position: Int)
}