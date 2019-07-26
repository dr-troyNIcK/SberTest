package ru.geekbreins.sbertest.presenter

import com.arellomobile.mvp.InjectViewState
import com.arellomobile.mvp.MvpPresenter
import ru.geekbreins.sbertest.view.MainActivityView

@InjectViewState
class MainActivityPresenter : MvpPresenter<MainActivityView>(), IMainActivityPresenter {

    override fun onTranslatorTabPushed() {
        viewState.navigateToTranslatorFragment()
    }

    override fun onVocabularyTabPushed() {
        viewState.navigateToVocabularyFragment()
    }
}