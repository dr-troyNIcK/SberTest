package ru.geekbreins.sbertest.view

import com.arellomobile.mvp.MvpView
import com.arellomobile.mvp.viewstate.strategy.AddToEndSingleStrategy
import com.arellomobile.mvp.viewstate.strategy.StateStrategyType

@StateStrategyType(AddToEndSingleStrategy::class)
interface LanguagesFragmentView : MvpView {
    fun updateLanguagesList()
    fun navigateToTranslatorFragment(numberOfLanguageTextView: String, position: Int)
}