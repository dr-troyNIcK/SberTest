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
class TranslatorFragmentPresenter(val numberOfLanguageTextView: String, val position: Int) :
    MvpPresenter<TranslatorFragmentView>(), ITranslatorFragmentPresenter {

    companion object {
        const val LANGUAGE_ONE: String = "One"
        const val LANGUAGE_TWO: String = "Two"
    }

    private val translatorRepo: TranslatorRepo = TranslatorRepo()
    private val languages: LanguagesRepo = LanguagesRepo.instance

    private var textViewLanguageOneState: Int = 1
    private var textViewLanguageTwoState: Int = 0
    private var textViewOutputState: String = ""

    init {
        when (numberOfLanguageTextView) {
            LANGUAGE_ONE -> {
                textViewLanguageOneState = position
            }
            LANGUAGE_TWO -> {
                textViewLanguageTwoState = position
            }
            else->{
                Timber.d("don't change")
            }
        }
        viewState.setLanguageOneText(languages.languages!![textViewLanguageOneState])
        viewState.setLanguageTwoText(languages.languages!![textViewLanguageTwoState])
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
        viewState.setLanguageOneText(languages.languages!![textViewLanguageTwoState])
        viewState.setLanguageTwoText(languages.languages!![textViewLanguageOneState])

        val temp: Int = textViewLanguageOneState
        textViewLanguageOneState = textViewLanguageTwoState
        textViewLanguageTwoState = temp

        viewState.setInputText(textViewOutputState)
    }

    @SuppressLint("CheckResult")
    override fun subscribeOnTextChange(changedText: Observable<CharSequence>) {
        changedText.subscribe({ text ->
            if (text.toString() == "") {
                viewState.setOutputText("")
                textViewOutputState = ""
            } else {
                translatorRepo.getTranslation(text.toString(), languages.languagesKeys!![textViewLanguageTwoState])
                    .observeOn(AndroidSchedulers.mainThread())
                    .subscribe({ transition ->
                        viewState.setOutputText(transition.text[0])
                        textViewOutputState = transition.text[0]
                    }, { e -> Timber.e(e) })
            }
        }, { e -> Timber.e(e) })
    }
}