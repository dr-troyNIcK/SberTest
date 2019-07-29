package ru.geekbreins.sbertest.view.ui

import android.content.Context
import android.os.Bundle
import android.support.v7.widget.DividerItemDecoration
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.arellomobile.mvp.MvpAppCompatFragment
import com.arellomobile.mvp.presenter.InjectPresenter
import com.arellomobile.mvp.presenter.ProvidePresenter
import ru.geekbreins.sbertest.R
import ru.geekbreins.sbertest.presenter.LanguagesFragmentPresenter
import ru.geekbreins.sbertest.view.LanguagesFragmentView
import ru.geekbreins.sbertest.view.MainActivityView


class LanguagesFragment : MvpAppCompatFragment(), LanguagesFragmentView {

    @InjectPresenter
    lateinit var languagesFragmentPresenter: LanguagesFragmentPresenter

    @ProvidePresenter
    fun providePresenter(): LanguagesFragmentPresenter {
        return LanguagesFragmentPresenter(arguments?.getString(LANGUAGE_FRAGMENT_TAG)!!)
    }

    private lateinit var mainActivityView: MainActivityView

    private lateinit var languagesFragmentRV: RecyclerView

    private lateinit var languagesRVAdapter: LanguagesRVAdapter

    companion object {
        fun getInstance(arg: String): LanguagesFragment {
            val fragment = LanguagesFragment()
            val args = Bundle()
            args.putString(LANGUAGE_FRAGMENT_TAG, arg)
            fragment.arguments = args
            return fragment
        }

        const val LANGUAGE_FRAGMENT_TAG: String = "arg"
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val view = inflater.inflate(R.layout.fragment_languages, container, false)

        languagesFragmentRV = view.findViewById(R.id.languages_fragment_recycler_view)
        languagesFragmentRV.layoutManager = LinearLayoutManager(activity)
        languagesFragmentRV.addItemDecoration(DividerItemDecoration(activity, DividerItemDecoration.VERTICAL))
        languagesRVAdapter = LanguagesRVAdapter(languagesFragmentPresenter.languagesRVPresenter)
        languagesFragmentRV.adapter = languagesRVAdapter

        return view
    }

    override fun onAttach(context: Context?) {
        super.onAttach(context)
        mainActivityView = context as MainActivityView
    }

    override fun updateLanguagesList() {
        languagesRVAdapter.notifyDataSetChanged()
    }

    override fun navigateToTranslatorFragment() {
        mainActivityView.navigateToTranslatorFragment()
    }
}