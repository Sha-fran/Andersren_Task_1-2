package com.example.andersren_task_1_2

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.andersren_task_1_2.databinding.RwItemBinding

class RecyclerViewAdapter(items: List<Int> = listOf(), val onItemClickListener:OnItemClickListener) :
    RecyclerView.Adapter<RecyclerViewHolder>() {
    private val itemsList: List<Int> = items

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerViewHolder {
        return RecyclerViewHolder(
            RwItemBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        )
    }

    override fun getItemCount(): Int = NUMBER_OF_ITEMS

    override fun onBindViewHolder(holder: RecyclerViewHolder, position: Int) {
        holder.image.setImageResource(itemsList[position])
        holder.image.setOnClickListener {
            onItemClickListener.onItemClick(position)
        }
    }
}

class RecyclerViewHolder(binding: RwItemBinding) : RecyclerView.ViewHolder(binding.root) {
    val image = binding.image
}

interface OnItemClickListener {
    fun onItemClick(position: Int)
}
