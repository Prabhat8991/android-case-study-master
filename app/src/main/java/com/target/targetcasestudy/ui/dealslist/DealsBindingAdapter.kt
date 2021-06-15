package com.target.targetcasestudy.ui.dealslist

import android.webkit.WebView
import android.widget.ImageView
import androidx.databinding.BindingAdapter
import com.bumptech.glide.Glide

@BindingAdapter("imageUrl")
fun ImageView.setImageUrl(url: String) {
    Glide.with(this.context).load(url).into(this)
}

@BindingAdapter("webContent")
fun WebView.setContent(content: String) {
    loadData(content, "text/html", "utf-8")
}