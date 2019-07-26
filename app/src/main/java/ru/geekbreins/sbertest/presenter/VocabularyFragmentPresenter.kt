package ru.geekbreins.sbertest.presenter

import com.arellomobile.mvp.InjectViewState
import com.arellomobile.mvp.MvpPresenter
import io.reactivex.Observable
import ru.geekbreins.sbertest.view.VocabularyFragmentView

@InjectViewState
class VocabularyFragmentPresenter : MvpPresenter<VocabularyFragmentView>(), IVocabularyFragmentPresenter {

    override fun onClearListPushed() {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun onSearchTextChanged(changedText: Observable<String>) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }
}