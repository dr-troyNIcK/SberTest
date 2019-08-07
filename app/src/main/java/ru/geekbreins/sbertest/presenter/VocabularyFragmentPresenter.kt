package ru.geekbreins.sbertest.presenter

import com.arellomobile.mvp.InjectViewState
import com.arellomobile.mvp.MvpPresenter
import io.reactivex.Observable
import ru.geekbreins.sbertest.view.VocabularyFragmentView
import ru.geekbreins.sbertest.view.VocabularyItemView

@InjectViewState
class VocabularyFragmentPresenter : MvpPresenter<VocabularyFragmentView>(), IVocabularyFragmentPresenter {

    inner class VocabularyRVPresenter : IVocabularyRVPresenter {

        override fun getVocabularyCount(): Int {
            return 0
        }

        override fun bindView(view: VocabularyItemView) {}

        override fun onVocabularyItemViewPushed(position: Int) {}
    }

    override fun onFirstViewAttach() {
        super.onFirstViewAttach()
    }

    override fun onClearListPushed() {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun onSearchTextChanged(changedText: Observable<String>) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }
}