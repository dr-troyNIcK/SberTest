package ru.geekbreins.sbertest.view.ui

import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import ru.geekbreins.sbertest.R
import ru.geekbreins.sbertest.presenter.ILanguagesRVPresenter
import ru.geekbreins.sbertest.view.LanguagesItemView

class LanguagesRVAdapter(val languagesRVPresenter: ILanguagesRVPresenter) :
    RecyclerView.Adapter<LanguagesRVAdapter.LanguagesViewHolder>() {
    override fun onCreateViewHolder(p0: ViewGroup, p1: Int) = LanguagesViewHolder(
        LayoutInflater.from(p0.context).inflate(
            R.layout.fragment_languages_item, p0, false
        )
    )

    override fun getItemCount(): Int {
        return languagesRVPresenter.getLanguagesCount()
    }

    override fun onBindViewHolder(p0: LanguagesViewHolder, p1: Int) {
        p0.position = p1
        languagesRVPresenter.bindView(p0)
        p0.view.setOnClickListener { languagesRVPresenter.onLanguageItemViewPushed(p1) }
    }

    inner class LanguagesViewHolder(val view: View) : RecyclerView.ViewHolder(view), LanguagesItemView {
        override var position: Int? = null
        override fun setLanguage(language: String) {
            view.findViewById<TextView>(R.id.languages_fragment_item_text_view_language).text = language
        }
    }
}