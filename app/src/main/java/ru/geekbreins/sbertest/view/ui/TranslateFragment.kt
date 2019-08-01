package ru.geekbreins.sbertest.view.ui

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.EditText
import android.widget.ImageView
import android.widget.TextView
import com.arellomobile.mvp.MvpAppCompatFragment
import com.arellomobile.mvp.presenter.InjectPresenter
import com.arellomobile.mvp.presenter.ProvidePresenter
import com.jakewharton.rxbinding2.widget.RxTextView
import io.reactivex.Observable
import kotlinx.android.synthetic.main.fragment_translator.*
import ru.geekbreins.sbertest.R
import ru.geekbreins.sbertest.presenter.TranslateFragmentPresenter
import ru.geekbreins.sbertest.view.MainActivityView
import ru.geekbreins.sbertest.view.TranslateFragmentView


class TranslateFragment : MvpAppCompatFragment(), TranslateFragmentView {

    @InjectPresenter
    lateinit var translatorFragmentPresenter: TranslateFragmentPresenter

    @ProvidePresenter
    fun providePresenter(): TranslateFragmentPresenter {
        return TranslateFragmentPresenter()
    }

    private lateinit var mainActivityView: MainActivityView

    private lateinit var translatorFragmentTextViewLanguageOne: TextView
    private lateinit var translatorFragmentTextViewLanguageTwo: TextView
    private lateinit var translatorFragmentImageViewReverseLanguageButton: ImageView
    private lateinit var translatorFragmentEditTextInput: EditText
    private lateinit var translatorFragmentTextViewOutput: TextView

    private lateinit var observableEditTextChanges: Observable<CharSequence>

    companion object {
        fun getInstance(arg: String): TranslateFragment {
            val fragment = TranslateFragment()
            val args = Bundle()
            args.putString("arg", arg)
            fragment.arguments = args
            return fragment
        }
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val view = inflater.inflate(R.layout.fragment_translator, container, false)
        translatorFragmentTextViewLanguageOne = view.findViewById(R.id.translator_fragment_text_view_language_1)
        translatorFragmentTextViewLanguageOne.setOnClickListener { translatorFragmentPresenter.onLanguageOnePushed() }
        translatorFragmentTextViewLanguageTwo = view.findViewById(R.id.translator_fragment_text_view_language_2)
        translatorFragmentTextViewLanguageTwo.setOnClickListener { translatorFragmentPresenter.onLanguageTwoPushed() }
        translatorFragmentImageViewReverseLanguageButton =
            view.findViewById(R.id.translator_fragment_reverse_language_button)
        translatorFragmentImageViewReverseLanguageButton.setOnClickListener { translatorFragmentPresenter.onReversLanguagePushed() }
        translatorFragmentEditTextInput = view.findViewById(R.id.translator_fragment_edit_text_input)
        observableEditTextChanges = RxTextView.textChanges(translatorFragmentEditTextInput)
        translatorFragmentPresenter.subscribeOnTextChange(observableEditTextChanges)
        translatorFragmentTextViewOutput = view.findViewById(R.id.translator_fragment_text_view_output)
        return view
    }

    override fun onAttach(context: Context?) {
        super.onAttach(context)
        mainActivityView = context as MainActivityView
    }

    override fun setLanguageOneText(inputText: String) {
        translator_fragment_text_view_language_1.text = inputText
    }

    override fun setLanguageTwoText(inputText: String) {
        translator_fragment_text_view_language_2.text = inputText
    }

    override fun setInputText(inputText: String) {
        translator_fragment_edit_text_input.setText(inputText)
    }

    override fun setOutputText(outputText: String) {
        translator_fragment_text_view_output.text = outputText
    }

    override fun navigateToLanguageFragment(numberOfLanguageTextView: String) {
        mainActivityView.navigateToLanguagesFragment(numberOfLanguageTextView)
    }
}