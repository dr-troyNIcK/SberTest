package ru.geekbreins.sbertest.presenter

import com.arellomobile.mvp.InjectViewState
import com.arellomobile.mvp.MvpPresenter
import ru.geekbreins.sbertest.model.repos.LanguagesRepo
import ru.geekbreins.sbertest.view.LanguagesFragmentView
import ru.geekbreins.sbertest.view.LanguagesItemView

@InjectViewState
class LanguagesFragmentPresenter(val numberOfLanguageTextView: String) : MvpPresenter<LanguagesFragmentView>() {

    inner class LanguagesRVPresenter : ILanguagesRVPresenter {
        override fun getLanguagesCount(): Int {
            return languagesRepo.languages!!.size
        }

        override fun bindView(view: LanguagesItemView) {
            view.setLanguage(languagesRepo.languages!![view.position!!])
        }

        override fun onLanguageItemViewPushed(position: Int) {
            viewState.navigateToTranslatorFragment(numberOfLanguageTextView, position)
        }
    }

    val languagesRVPresenter = LanguagesRVPresenter()
    val languagesRepo: LanguagesRepo = LanguagesRepo.instance

    override fun onFirstViewAttach() {
        super.onFirstViewAttach()
    }

}