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
    private lateinit var languagesFragment: LanguagesFragment

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
        languagesFragment = LanguagesFragment.getInstance("arg")

        navigateToTranslatorFragment()

        initBottomNavigationView()
    }

    override fun onBackPressed() {
        when (supportFragmentManager.findFragmentById(R.id.main_activity_fragment_container)) {
            is LanguagesFragment -> navigateToTranslatorFragment()
            else -> super.onBackPressed()
        }
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
            .commit()
    }

    override fun navigateToVocabularyFragment() {
        supportFragmentManager.beginTransaction().replace(R.id.main_activity_fragment_container, vocabularyFragment)
            .commit()
    }

    override fun navigateToLanguagesFragment() {
        supportFragmentManager.beginTransaction().replace(R.id.main_activity_fragment_container, languagesFragment)
            .commit()
    }
}