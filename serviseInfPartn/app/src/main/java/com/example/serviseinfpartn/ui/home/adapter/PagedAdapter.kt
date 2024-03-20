package com.example.serviseinfpartn.ui.home.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.paging.PagingDataAdapter
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.example.serviseinfpartn.data.models.ResponseApiItem
import com.example.serviseinfpartn.databinding.UsersLayoutBinding

class PagedAdapter(
    private val onClickUser: (ResponseApiItem) -> Unit
) :
    PagingDataAdapter<ResponseApiItem, PagedAdapter.MyViewHolder>(diffCallback) {

    inner class MyViewHolder(val binding: UsersLayoutBinding) :
        RecyclerView.ViewHolder(binding.root)


    companion object {
        val diffCallback = object : DiffUtil.ItemCallback<ResponseApiItem>() {
            override fun areItemsTheSame(
                oldItem: ResponseApiItem,
                newItem: ResponseApiItem
            ): Boolean {
                return oldItem.id == newItem.id
            }

            override fun areContentsTheSame(
                oldItem: ResponseApiItem,
                newItem: ResponseApiItem
            ): Boolean {
                return oldItem == newItem
            }

        }
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        val currentItem = getItem(position)
        holder.binding.apply {
            textViewUser.text = "${currentItem?.name}"

        }
        holder.binding.root.setOnClickListener {

            currentItem?.let { it1 -> onClickUser(it1) }

        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        return MyViewHolder(
            UsersLayoutBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        )
    }
}