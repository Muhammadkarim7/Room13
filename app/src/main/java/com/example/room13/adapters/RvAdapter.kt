package com.example.room13.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.room13.databinding.ItemRvBinding
import com.example.room13.models.MyContact

class RvAdapter (var list:ArrayList<MyContact> = ArrayList()): RecyclerView.Adapter<RvAdapter.Vh>() {

    inner class Vh(var itemRvBinding:ItemRvBinding): RecyclerView.ViewHolder(itemRvBinding.root){

        fun onBind(myContact: MyContact){
            itemRvBinding.tvName.text = myContact.name
            itemRvBinding.tvNumber.text = myContact.number
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): Vh {
        return Vh(ItemRvBinding.inflate(LayoutInflater.from(parent.context), parent, false))
    }

    override fun getItemCount(): Int = list.size

    override fun onBindViewHolder(holder: Vh, position: Int) {
        holder.onBind(list[position])
    }
}