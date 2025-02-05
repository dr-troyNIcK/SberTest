package ru.geekbreins.sbertest.view

import com.arellomobile.mvp.MvpView
import com.arellomobile.mvp.viewstate.strategy.AddToEndSingleStrategy
import com.arellomobile.mvp.viewstate.strategy.StateStrategyType

@StateStrategyType(AddToEndSingleStrategy::class)
interface MainActivityView : MvpView {
    fun navigateToTranslatorFragment()
    fun navigateToVocabularyFragment()
    fun navigateToLanguagesFragment(numberOfLanguageTextView: String)
}