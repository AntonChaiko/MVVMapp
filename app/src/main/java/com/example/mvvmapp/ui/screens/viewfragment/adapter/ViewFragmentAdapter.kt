package com.example.mvvmapp.ui.screens.viewfragment.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.domain.model.EmployeeModel
import com.example.mvvmapp.R
import com.example.mvvmapp.databinding.RecyclerViewItemBinding

class ViewFragmentAdapter :
    ListAdapter<EmployeeModel, ViewFragmentAdapter.ItemViewHolder>(DiffCallback) {

    companion object DiffCallback : DiffUtil.ItemCallback<EmployeeModel>() {

        override fun areItemsTheSame(oldItem: EmployeeModel, newItem: EmployeeModel): Boolean {
            return oldItem.id == newItem.id
        }

        override fun areContentsTheSame(oldItem: EmployeeModel, newItem: EmployeeModel): Boolean {
            return oldItem.email == newItem.email
        }
    }

    inner class ItemViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        private val binding = RecyclerViewItemBinding.bind(itemView)

        fun bind(item: EmployeeModel) = with(itemView) {
           binding.fullNameTextView.text = item.name

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
/*inner class ItemViewHolder(private val binding: RecyclerViewItemBinding) :
    RecyclerView.ViewHolder(binding.root) {

    fun bind(item: EmployeeModel) {
        binding.fullNameTextView.text = item.name
        *//*      binding.colorNameTextView.text = item.colorName
                binding.colorImageView.setImageResource(item.color)
                binding.copyButton.setOnClickListener { copyHex(item.hex) }*//*
    }
}*/
