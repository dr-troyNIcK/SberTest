package ru.geekbreins.sbertest.view.ui

import android.os.Bundle
import android.support.design.widget.BottomNavigationView
import com.arellomobile.mvp.MvpAppCompatActivity
import com.arellomobile.mvp.presenter.InjectPresenter
import com.arellomobile.mvp.presenter.ProvidePresenter
import ru.geekbreins.sbertest.R
import ru.geekbreins.sbertest.presenter.MainActivityPresenter
import ru.geekbreins.sbertest.view.MainActivityView

class MainActivity : MvpAppCompatActivity(), MainActivityView {

    private lateinit var mainActivityBottomNavigationView: BottomNavigationView

    private lateinit var translatorFragment: TranslatorFragment
    private lateinit var vocabularyFragment: VocabularyFragment
    private lateinit var languagesListFragment: LanguagesListFragment

    @InjectPresenter
    lateinit var mainActivityPresenter: MainActivityPresenter

    @ProvidePresenter
    fun providePresenter() = MainActivityPresenter()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        mainActivityBottomNavigationView = findViewById(R.id.main_activity_bottom_navigation_view)
        translatorFragment = TranslatorFragment.getInstance("arg")
        vocabularyFragment = VocabularyFragment.getInstance("arg")
        languagesListFragment = LanguagesListFragment.getInstance("arg")

        navigateToTranslatorFragment()

        initBottomNavigationView()
    }

    private fun initBottomNavigationView() {
        mainActivityBottomNavigationView.setOnNavigationItemSelectedListener(BottomNavigationView.OnNavigationItemSelectedListener { item ->
            when (item.itemId) {
                R.id.navigation_translator -> {
                    mainActivityPresenter.onTranslatorTabPushed()
                    return@OnNavigationItemSelectedListener true
                }
                R.id.navigation_vocabulary -> {
                    mainActivityPresenter.onVocabularyTabPushed()
                    return@OnNavigationItemSelectedListener true
                }
                else -> false
            }
        })
    }

    override fun navigateToTranslatorFragment() {
        supportFragmentManager.beginTransaction().replace(R.id.main_activity_fragment_container, translatorFragment)
            .addToBackStack(null).commit()
    }

    override fun navigateToVocabularyFragment() {
        supportFragmentManager.beginTransaction().replace(R.id.main_activity_fragment_container, vocabularyFragment)
            .addToBackStack(null).commit()
    }

    override fun navigateToLanguageListFragment() {
        supportFragmentManager.beginTransaction().replace(R.id.main_activity_fragment_container, languagesListFragment)
            .addToBackStack(null).commit()
    }
}