package com.mnashat_dev.quraanzareem.ui.mainscreenfragment

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.mnashat_dev.quraanzareem.databinding.ItemNumberPageBinding
import com.mnashat_dev.quraanzareem.ui.model.Page


class PageAdapter (private val clickListener: PageListener) :
    ListAdapter<Page, PageAdapter.PlayListViewHolder>(PageDiffUtil()) {


    class PlayListViewHolder private constructor(val binding: ItemNumberPageBinding) :
        RecyclerView.ViewHolder(binding.root) {

        fun bind(
            page: Page, clickListener: PageListener
        ) {

            binding.page = page
            binding.clickListener = clickListener
            binding.executePendingBindings()

        }

        companion object {
            fun from(parent: ViewGroup): PlayListViewHolder {
                val layoutInflater = LayoutInflater.from(parent.context)
                val binding = ItemNumberPageBinding.inflate(layoutInflater, parent, false)

                return PlayListViewHolder(binding)
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PlayListViewHolder {
        return PlayListViewHolder.from(parent)
    }

    override fun onBindViewHolder(holder: PlayListViewHolder, position: Int) {
        holder.bind(getItem(position), clickListener)
    }
}


class PageDiffUtil() : DiffUtil.ItemCallback<Page>() {
    override fun areItemsTheSame(oldItem: Page, newItem: Page): Boolean {
        return oldItem.number == newItem.number
    }

    override fun areContentsTheSame(oldItem: Page, newItem: Page): Boolean {
        return oldItem == newItem
    }

}


class PageListener(private val clickListener: (page: Page) -> Unit) {

    fun onClick(page: Page) = clickListener(page)
}