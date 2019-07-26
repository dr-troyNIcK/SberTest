package ru.geekbreins.sbertest.presenter

import com.arellomobile.mvp.InjectViewState
import com.arellomobile.mvp.MvpPresenter
import io.reactivex.Observable
import ru.geekbreins.sbertest.view.TranslatorFragmentView

@InjectViewState
class TranslatorFragmentPresenter : MvpPresenter<TranslatorFragmentView>(), ITranslatorFragmentPresenter {

    override fun onLanguageOnePushed() {
//        viewState.navigateToLanguageListFragment()
    }

    override fun onLanguageTwoPushed() {
//        viewState.navigateToLanguageListFragment()
    }

    override fun onReversLanguagePushed() {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun onInputTextChanged(changedText: Observable<String>) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }
}