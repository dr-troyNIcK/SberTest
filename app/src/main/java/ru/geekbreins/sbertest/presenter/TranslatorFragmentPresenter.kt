package ru.geekbreins.sbertest.presenter

import android.annotation.SuppressLint
import com.arellomobile.mvp.InjectViewState
import com.arellomobile.mvp.MvpPresenter
import io.reactivex.Observable
import io.reactivex.android.schedulers.AndroidSchedulers
import ru.geekbreins.sbertest.model.repos.LanguagesRepo
import ru.geekbreins.sbertest.model.repos.TranslatorRepo
import ru.geekbreins.sbertest.view.TranslatorFragmentView
import timber.log.Timber

@InjectViewState
class TranslatorFragmentPresenter : MvpPresenter<TranslatorFragmentView>(), ITranslatorFragmentPresenter {

    companion object {
        const val LANGUAGE_ONE: String = "One"
        const val LANGUAGE_TWO: String = "Two"
    }

    private val translatorRepo: TranslatorRepo = TranslatorRepo()
    private val languages: LanguagesRepo = LanguagesRepo.instance

    private var textViewOutputState: String = ""

    init {
        viewState.setLanguageOneText(languages.languages!![languages.languageOneState])
        viewState.setLanguageTwoText(languages.languages!![languages.languageTwoState])
    }

    override fun onFirstViewAttach() {
        super.onFirstViewAttach()
    }

    override fun onLanguageOnePushed() {
        viewState.navigateToLanguageFragment(LANGUAGE_ONE)
    }

    override fun onLanguageTwoPushed() {
        viewState.navigateToLanguageFragment(LANGUAGE_TWO)
    }

    override fun onReversLanguagePushed() {
        viewState.setLanguageOneText(languages.languages!![languages.languageTwoState])
        viewState.setLanguageTwoText(languages.languages!![languages.languageOneState])

        val temp: Int = languages.languageOneState
        languages.languageOneState = languages.languageTwoState
        languages.languageTwoState = temp

        viewState.setInputText(textViewOutputState)
    }

    @SuppressLint("CheckResult")
    override fun subscribeOnTextChange(changedText: Observable<CharSequence>) {
        changedText.subscribe({ text ->
            if (text.toString() == "") {
                viewState.setOutputText("")
                textViewOutputState = ""
            } else {
                translatorRepo.getTranslation(text.toString(), languages.languagesKeys!![languages.languageTwoState])
                    .observeOn(AndroidSchedulers.mainThread())
                    .subscribe({ transition ->
                        viewState.setOutputText(transition.text[0])
                        textViewOutputState = transition.text[0]
                    }, { e -> Timber.e(e) })
            }
        }, { e -> Timber.e(e) })
    }
}