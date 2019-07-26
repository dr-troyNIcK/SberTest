package ru.geekbreins.sbertest.view.ui

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import com.arellomobile.mvp.MvpAppCompatFragment
import com.arellomobile.mvp.presenter.InjectPresenter
import com.arellomobile.mvp.presenter.ProvidePresenter
import kotlinx.android.synthetic.main.fragment_translator.*
import ru.geekbreins.sbertest.R
import ru.geekbreins.sbertest.presenter.TranslatorFragmentPresenter
import ru.geekbreins.sbertest.view.MainActivityView
import ru.geekbreins.sbertest.view.TranslatorFragmentView


class TranslatorFragment : MvpAppCompatFragment(), TranslatorFragmentView {

    @InjectPresenter
    lateinit var translatorFragmentPresenter: TranslatorFragmentPresenter

    @ProvidePresenter
    fun providePresenter() = TranslatorFragmentPresenter()

    private lateinit var mainActivityView: MainActivityView

    companion object {
        fun getInstance(arg: String): TranslatorFragment {
            val fragment = TranslatorFragment()
            val args = Bundle()
            args.putString("arg", arg)
            fragment.arguments = args
            return fragment
        }
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val view = inflater.inflate(R.layout.fragment_translator, container, false)
        val translatorFragmentTextViewLanguageOne: TextView =
            view.findViewById(R.id.translator_fragment_text_view_language_1)
        translatorFragmentTextViewLanguageOne.setOnClickListener { translatorFragmentPresenter.onLanguageOnePushed() }
        val translatorFragmentTextViewLanguageTwo: TextView =
            view.findViewById(R.id.translator_fragment_text_view_language_2)
        translatorFragmentTextViewLanguageTwo.setOnClickListener { translatorFragmentPresenter.onLanguageTwoPushed() }
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

    override fun navigateToLanguageListFragment() {
        mainActivityView.navigateToLanguageListFragment()
    }
}