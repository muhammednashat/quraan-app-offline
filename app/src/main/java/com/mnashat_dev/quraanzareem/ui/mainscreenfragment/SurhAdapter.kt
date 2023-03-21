package com.mnashat_dev.quraanzareem.ui.mainscreenfragment

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.mnashat_dev.quraanzareem.databinding.ItemNameSurhBinding
import com.mnashat_dev.quraanzareem.ui.model.Juz
import com.mnashat_dev.quraanzareem.ui.model.Surh


class SurhAdapter (private val clickListener: SurhListener) :
    ListAdapter<Surh, SurhAdapter.PlayListViewHolder>(SurhDiffUtil()) {


    class PlayListViewHolder private constructor(val binding: ItemNameSurhBinding) :
        RecyclerView.ViewHolder(binding.root) {

        fun bind(
            surh: Surh, clickListener: SurhListener
        ) {

            binding.surh = surh
            binding.clickListener = clickListener
            binding.executePendingBindings()

        }

        companion object {
            fun from(parent: ViewGroup): PlayListViewHolder {
                val layoutInflater = LayoutInflater.from(parent.context)
                val binding = ItemNameSurhBinding.inflate(layoutInflater, parent, false)

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


class SurhDiffUtil() : DiffUtil.ItemCallback<Surh>() {
    override fun areItemsTheSame(oldItem: Surh, newItem: Surh): Boolean {
        return oldItem.number== newItem.number
    }

    override fun areContentsTheSame(oldItem: Surh, newItem: Surh): Boolean {
        return oldItem == newItem
    }

}


class SurhListener(private val clickListener: (item: Surh) -> Unit) {

    fun onClick(item: Surh) = clickListener(item)
}