package com.example.andersren_task_1_2

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.andersren_task_1_2.databinding.RwItemBinding

class RecyclerViewAdapter(val items: List<Int> = listOf()) :
    RecyclerView.Adapter<RecyclerViewHolder>() {
    private val itemsList:List<Int> = items

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

        }
    }
}

class RecyclerViewHolder(binding: RwItemBinding) : RecyclerView.ViewHolder(binding.root) {
    val image = binding.image
}
