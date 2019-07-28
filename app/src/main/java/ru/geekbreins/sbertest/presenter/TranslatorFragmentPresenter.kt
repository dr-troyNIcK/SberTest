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

    private val translatorRepo: TranslatorRepo = TranslatorRepo()

    private val languages: LanguagesRepo = LanguagesRepo.instance
    private var textViewLanguageOneState: String = languages.languagesKeys!![1]
    private var textViewLanguageTwoState: String = languages.languagesKeys!![0]
    private var textViewOutputState: String = ""

    init {
        viewState.setLanguageOneText(textViewLanguageOneState)
        viewState.setLanguageTwoText(textViewLanguageTwoState)
    }

    override fun onFirstViewAttach() {
        super.onFirstViewAttach()
    }

    override fun onLanguageOnePushed() {
        viewState.navigateToLanguageFragment()
    }

    override fun onLanguageTwoPushed() {
        viewState.navigateToLanguageFragment()
    }

    override fun onReversLanguagePushed() {
        viewState.setLanguageOneText(textViewLanguageTwoState)
        viewState.setLanguageTwoText(textViewLanguageOneState)

        val temp: String = textViewLanguageOneState
        textViewLanguageOneState = textViewLanguageTwoState
        textViewLanguageTwoState = temp

        viewState.setInputText(textViewOutputState)
    }

    @SuppressLint("CheckResult")
    override fun onInputTextChanged(changedText: Observable<CharSequence>) {
        changedText.subscribe({ text ->
            translatorRepo.getTranslation(text.toString(), "ru").observeOn(AndroidSchedulers.mainThread())
                .subscribe({ transition ->
                    viewState.setOutputText(transition.text[0])
                }, { e -> Timber.e(e) })
        }, { e -> Timber.e(e) })
    }
}