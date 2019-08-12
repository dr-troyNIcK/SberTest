package ru.geekbreins.sbertest.presenter

import android.annotation.SuppressLint
import com.arellomobile.mvp.InjectViewState
import com.arellomobile.mvp.MvpPresenter
import io.reactivex.Observable
import io.reactivex.android.schedulers.AndroidSchedulers
import ru.geekbreins.sbertest.model.local.LanguagesRepo
import ru.geekbreins.sbertest.model.remote.yandexTranslate.YandexTranslateRepo
import ru.geekbreins.sbertest.view.TranslateFragmentView
import timber.log.Timber

@InjectViewState
class TranslateFragmentPresenter : MvpPresenter<TranslateFragmentView>(), ITranslateFragmentPresenter {

    companion object {
        const val LANGUAGE_ONE: String = "One"
        const val LANGUAGE_TWO: String = "Two"
    }

    private val yandexTranslateRepo: YandexTranslateRepo = YandexTranslateRepo()
    private val languagesRepo: LanguagesRepo = LanguagesRepo.getInstance()

    init {
        viewState.setLanguageOneText(languagesRepo.languages[languagesRepo.languageOneState])
        viewState.setLanguageTwoText(languagesRepo.languages[languagesRepo.languageTwoState])
        viewState.setInputText(languagesRepo.inputTextState)
        viewState.setOutputText(languagesRepo.outputTextState)
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
        viewState.setLanguageOneText(languagesRepo.languages[languagesRepo.languageTwoState])
        viewState.setLanguageTwoText(languagesRepo.languages[languagesRepo.languageOneState])

        val tempLanguage: Int = languagesRepo.languageOneState
        languagesRepo.languageOneState = languagesRepo.languageTwoState
        languagesRepo.languageTwoState = tempLanguage

        viewState.setInputText(languagesRepo.outputTextState)
        viewState.setOutputText(languagesRepo.inputTextState)

        val tempText: String = languagesRepo.inputTextState
        languagesRepo.inputTextState = languagesRepo.outputTextState
        languagesRepo.outputTextState = tempText
    }

    @SuppressLint("CheckResult")
    override fun subscribeOnTextChange(changedText: Observable<CharSequence>) {
        changedText.subscribe({ text ->
            if (text.toString() == "") {
//                viewState.setInputText("")
                viewState.setOutputText("")
                languagesRepo.inputTextState = ""
                languagesRepo.outputTextState = ""
            } else {
                yandexTranslateRepo.getTranslation(
                    text.toString(),
                    languagesRepo.languagesKeys[languagesRepo.languageTwoState]
                )
                    .observeOn(AndroidSchedulers.mainThread())
                    .subscribe({ transition ->
                        //                        viewState.setInputText(text.toString())
                        viewState.setOutputText(transition.text[0])
                        languagesRepo.inputTextState = text.toString()
                        languagesRepo.outputTextState = transition.text[0]
                    }, { e -> Timber.e(e) })
            }
        }, { e -> Timber.e(e) })
    }
}