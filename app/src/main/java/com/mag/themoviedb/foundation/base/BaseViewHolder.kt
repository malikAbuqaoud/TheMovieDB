package com.mag.themoviedb.foundation.base

import android.view.View
import androidx.recyclerview.widget.RecyclerView

abstract class BaseViewHolder<T> constructor(view: View) : RecyclerView.ViewHolder(view) {
    abstract fun bind(item: T)
}
