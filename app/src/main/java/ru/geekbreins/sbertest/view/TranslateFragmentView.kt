package ru.geekbreins.sbertest.view

import com.arellomobile.mvp.MvpView
import com.arellomobile.mvp.viewstate.strategy.AddToEndSingleStrategy
import com.arellomobile.mvp.viewstate.strategy.StateStrategyType

@StateStrategyType(AddToEndSingleStrategy::class)
interface TranslateFragmentView : MvpView {
    fun setLanguageOneText(inputText: String)
    fun setLanguageTwoText(inputText: String)
    fun setInputText(inputText: String)
    fun setOutputText(outputText: String)
    fun navigateToLanguageFragment(numberOfLanguageTextView: String)
}