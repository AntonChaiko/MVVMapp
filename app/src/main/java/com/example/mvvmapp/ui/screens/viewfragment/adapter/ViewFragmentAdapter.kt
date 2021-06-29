package com.example.mvvmapp.ui.screens.viewfragment.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.mvvmapp.R
import com.example.mvvmapp.databinding.RecyclerViewItemBinding
import com.example.mvvmapp.room.Persons

class ViewFragmentAdapter :
    ListAdapter<Persons, ViewFragmentAdapter.ItemViewHolder>(DiffCallback()) {

    inner class ItemViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        private val binding = RecyclerViewItemBinding.bind(itemView)

        fun bind(item: Persons) = with(itemView) {
            /*       binding.colorHexTextView.text = item.hex
                   binding.colorNameTextView.text = item.colorName
                   binding.colorImageView.setImageResource(item.color)*/

        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ItemViewHolder {
        val itemView = LayoutInflater.from(parent.context)
            .inflate(R.layout.recycler_view_item, parent, false)
        return ItemViewHolder(itemView)
    }

    override fun onBindViewHolder(holder: ItemViewHolder, position: Int) {
        holder.bind(getItem(position))
    }

}

class DiffCallback : DiffUtil.ItemCallback<Persons>() {

    override fun areItemsTheSame(
        oldItem: Persons,
        newItem: Persons
    ): Boolean = true

    override fun areContentsTheSame(
        oldItem: Persons,
        newItem: Persons
    ): Boolean = oldItem == newItem

}