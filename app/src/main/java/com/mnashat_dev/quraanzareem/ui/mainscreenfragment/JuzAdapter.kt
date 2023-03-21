package com.mnashat_dev.quraanzareem.ui.mainscreenfragment

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.mnashat_dev.quraanzareem.databinding.ItemNameJuzBinding
import com.mnashat_dev.quraanzareem.ui.model.Juz

class JuzAdapter (private val clickListener: JuzListener) :
    ListAdapter<Juz, JuzAdapter.JuzViewHolder>(JuzDiffUtil()) {


    class JuzViewHolder private constructor(val binding: ItemNameJuzBinding) :
        RecyclerView.ViewHolder(binding.root) {

        fun bind(
            item: Juz, clickListener: JuzListener
        ) {

            binding.juz = item
            binding.clickListener = clickListener
            binding.executePendingBindings()

        }

        companion object {
            fun from(parent: ViewGroup): JuzViewHolder {
                val layoutInflater = LayoutInflater.from(parent.context)
                val binding = ItemNameJuzBinding.inflate(layoutInflater, parent, false)

                return JuzViewHolder(binding)
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): JuzViewHolder {
        return JuzViewHolder.from(parent)
    }

    override fun onBindViewHolder(holder: JuzViewHolder, position: Int) {
        holder.bind(getItem(position), clickListener)
    }
}


class JuzDiffUtil() : DiffUtil.ItemCallback<Juz>() {
    override fun areItemsTheSame(oldItem: Juz, newItem: Juz): Boolean {
        return oldItem.number == newItem.number
    }

    override fun areContentsTheSame(oldItem: Juz, newItem: Juz): Boolean {
        return oldItem == newItem
    }

}


class JuzListener(private val clickListener: (item: Juz) -> Unit) {

    fun onClick(item: Juz) = clickListener(item)
}