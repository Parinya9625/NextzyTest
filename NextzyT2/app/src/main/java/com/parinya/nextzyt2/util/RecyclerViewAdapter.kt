package com.parinya.nextzyt2.util

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding
import androidx.recyclerview.widget.RecyclerView
import com.parinya.nextzyt2.BR
import com.parinya.nextzyt2.R
import com.parinya.nextzyt2.domain.model.Article

class RecyclerViewAdapter: RecyclerView.Adapter<RecyclerViewAdapter.ViewHolder>() {

    var articles: List<Article> = emptyList()

    class ViewHolder(private val binding: ViewDataBinding): RecyclerView.ViewHolder(binding.root) {
        fun bind(article: Article) {
            binding.setVariable(BR.article, article)
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val binding: ViewDataBinding = DataBindingUtil.inflate(LayoutInflater.from(parent.context), R.layout.article_list_tile, parent, false)
        return ViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(articles[position])

        holder.itemView.setOnClickListener {
            onItemClickListener?.let {
                it(articles[position])
            }
        }
    }

    override fun getItemCount(): Int = articles.size

    fun updateItems(items: List<Article>?) {
        articles = items ?: emptyList()
        notifyDataSetChanged()
    }

    private var onItemClickListener: ((Article) -> Unit)? = null

    fun setOnItemClickListener(listener: ((Article) -> Unit)) {
        onItemClickListener = listener
    }
}