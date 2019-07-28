package ru.geekbreins.sbertest.view.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.arellomobile.mvp.MvpAppCompatFragment
import com.arellomobile.mvp.presenter.InjectPresenter
import com.arellomobile.mvp.presenter.ProvidePresenter
import ru.geekbreins.sbertest.R
import ru.geekbreins.sbertest.presenter.LanguagesListFragmentPresenter
import ru.geekbreins.sbertest.view.LanguagesFragmentView


class LanguagesFragment : MvpAppCompatFragment(), LanguagesFragmentView {

    @InjectPresenter
    lateinit var languagesListFragmentPresenter: LanguagesListFragmentPresenter

    @ProvidePresenter
    fun providePresenter() = LanguagesFragment()

    companion object {
        fun getInstance(arg: String): LanguagesFragment {
            val fragment = LanguagesFragment()
            val args = Bundle()
            args.putString("arg", arg)
            fragment.setArguments(args)
            return fragment
        }
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val view = inflater.inflate(R.layout.fragment_languages, container, false)
        return view
    }

    override fun updateLanguagesList() {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun navigateToTranslatorFragment() {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }
}