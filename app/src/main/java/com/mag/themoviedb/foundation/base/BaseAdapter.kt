package com.mag.themoviedb.foundation.base

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView

abstract class BaseAdapter<T>(private val listItems: List<T> = listOf<T>()):
    RecyclerView.Adapter<BaseViewHolder<T>>() {

    abstract fun getViewHolder(view: View, viewType: Int): BaseViewHolder<T>

    abstract fun layoutId(viewType: Int): Int

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BaseViewHolder<T> {
        val inflate = LayoutInflater.from(parent.context).inflate(layoutId(viewType), parent, false)
        return getViewHolder(inflate, viewType)
    }

    override fun onBindViewHolder(holder: BaseViewHolder<T>, position: Int) {
        holder.bind(listItems[position])
    }

    override fun getItemCount(): Int = listItems.size
}
