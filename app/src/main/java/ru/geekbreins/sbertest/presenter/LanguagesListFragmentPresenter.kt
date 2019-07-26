package ru.geekbreins.sbertest.presenter

import com.arellomobile.mvp.InjectViewState
import com.arellomobile.mvp.MvpPresenter
import ru.geekbreins.sbertest.view.LanguagesListFragmentView

@InjectViewState
class LanguagesListFragmentPresenter : MvpPresenter<LanguagesListFragmentView>(), ILanguagesListFragmentPresenter {
}