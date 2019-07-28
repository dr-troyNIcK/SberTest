package ru.geekbreins.sbertest.view.ui

import android.support.v7.widget.RecyclerView
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import ru.geekbreins.sbertest.R
import ru.geekbreins.sbertest.view.VocabularyItemView

class VocabularyRVAdapter : RecyclerView.Adapter<VocabularyRVAdapter.VocabularyViewHolder>() {
    override fun onCreateViewHolder(p0: ViewGroup, p1: Int): VocabularyViewHolder {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun getItemCount(): Int {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun onBindViewHolder(p0: VocabularyViewHolder, p1: Int) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    inner class VocabularyViewHolder(val view: View) : RecyclerView.ViewHolder(view), VocabularyItemView {
        override var position: Int? = null
        override fun setTextOne(text: String) {
            view.findViewById<TextView>(R.id.vocabulary_fragment_item_text_view_one).text = text
        }

        override fun setTextTwo(text: String) {
            view.findViewById<TextView>(R.id.vocabulary_fragment_item_text_view_two).text = text
        }
    }
}