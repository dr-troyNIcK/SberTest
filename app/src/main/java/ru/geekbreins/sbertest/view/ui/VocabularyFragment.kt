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
import ru.geekbreins.sbertest.presenter.VocabularyFragmentPresenter
import ru.geekbreins.sbertest.view.MainActivityView
import ru.geekbreins.sbertest.view.VocabularyFragmentView


class VocabularyFragment : MvpAppCompatFragment(), VocabularyFragmentView {

    @InjectPresenter
    lateinit var vocabularyFragmentPresenter: VocabularyFragmentPresenter

    @ProvidePresenter
    fun providePresenter() = VocabularyFragmentPresenter()

    private lateinit var mainActivityView: MainActivityView

    private lateinit var vocabularyFragmentRV: RecyclerView

    private lateinit var vocabularyRVAdapter: VocabularyRVAdapter

    companion object {
        fun getInstance(arg: String): VocabularyFragment {
            val fragment = VocabularyFragment()
            val args = Bundle()
            args.putString(LANGUAGE_FRAGMENT_TAG, arg)
            fragment.setArguments(args)
            return fragment
        }

        const val LANGUAGE_FRAGMENT_TAG: String = "arg"
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val view = inflater.inflate(R.layout.fragment_vocabulary, container, false)

        vocabularyFragmentRV = view.findViewById(R.id.vocabulary_fragment_recycler_view)
        vocabularyFragmentRV.layoutManager = LinearLayoutManager(activity)
        vocabularyFragmentRV.addItemDecoration(DividerItemDecoration(activity, DividerItemDecoration.VERTICAL))
        vocabularyRVAdapter = VocabularyRVAdapter()
        vocabularyFragmentRV.adapter = vocabularyRVAdapter

        return view
    }

    override fun onAttach(context: Context?) {
        super.onAttach(context)
        mainActivityView = context as MainActivityView
    }

    override fun updateVocabularyList() {
        vocabularyRVAdapter.notifyDataSetChanged()
    }
}