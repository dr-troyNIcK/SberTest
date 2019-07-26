package ru.geekbreins.sbertest.view.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.arellomobile.mvp.MvpAppCompatFragment
import com.arellomobile.mvp.presenter.InjectPresenter
import com.arellomobile.mvp.presenter.ProvidePresenter
import ru.geekbreins.sbertest.R
import ru.geekbreins.sbertest.presenter.VocabularyFragmentPresenter
import ru.geekbreins.sbertest.view.VocabularyFragmentView


class VocabularyFragment : MvpAppCompatFragment(), VocabularyFragmentView {

    @InjectPresenter
    lateinit var vocabularyFragmentPresenter: VocabularyFragmentPresenter

    @ProvidePresenter
    fun providePresenter() = VocabularyFragmentPresenter()

    companion object {
        fun getInstance(arg: String): VocabularyFragment {
            val fragment = VocabularyFragment()
            val args = Bundle()
            args.putString("arg", arg)
            fragment.setArguments(args)
            return fragment
        }
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val view = inflater.inflate(R.layout.fragment_vocabulary, container, false)
        return view
    }

    override fun updateVocabularyList() {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }
}