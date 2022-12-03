package com.parinya.nextzyt2.util

import android.view.View
import android.widget.ImageView
import android.widget.TextView
import androidx.core.net.toUri
import androidx.databinding.BindingAdapter
import androidx.recyclerview.widget.RecyclerView
import coil.load
import com.parinya.nextzyt2.domain.model.Article
import java.text.SimpleDateFormat
import java.util.*

@BindingAdapter("items")
fun RecyclerView.items(items: List<Article>?) {
    val adapter = getAdapter(this)
    adapter.updateItems(items)
}

private fun getAdapter(recyclerView: RecyclerView): RecyclerViewAdapter {
    if (recyclerView.adapter != null && recyclerView.adapter is RecyclerViewAdapter) {
        return recyclerView.adapter as RecyclerViewAdapter
    } else {
        val adapter = RecyclerViewAdapter()
        recyclerView.adapter = adapter
        return adapter
    }
}

@BindingAdapter("imageUrl")
fun ImageView.imageUrl(url: String?) {
    url?.let {
        val uri = url.toUri().buildUpon().scheme("https").build()
        this.load(uri)
    }
}

@BindingAdapter("textDateTime")
fun TextView.textDateTime(text: String?) {
    text?.let {
        val format = SimpleDateFormat("yyyy-MM-dd'T'hh:mm:ss")
        this.text = format.parse(text)?.toString() ?: ""
    }
}

@BindingAdapter("hideEmptyData")
fun hideEmptyData(view: View, data: String?) {
    if (data.isNullOrBlank()) {
        view.visibility = View.GONE
    }
}

@BindingAdapter("isVisible")
fun isVisible(view: View, visible: Boolean) {
    view.visibility = if (visible) View.VISIBLE else View.GONE
}