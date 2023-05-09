package com.example.football6.adapter

import android.annotation.SuppressLint
import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.football6.R
import com.example.football6.model.playerItem
import kotlinx.android.synthetic.main.item_best_player.view.*

class PlayerAdapter(private val context: Context):RecyclerView.Adapter<PlayerAdapter.PlayerViewHolder>() {

    var list = emptyList<playerItem>()

    class PlayerViewHolder(view: View):RecyclerView.ViewHolder(view)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PlayerViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_best_player,parent,false)
        return PlayerViewHolder(view)
    }

    override fun onBindViewHolder(holder: PlayerViewHolder, position: Int) {
        Glide.with(context)
            .load(list[position].image)
            .into(holder.itemView.id_item_image_player)
        holder.itemView.id_item_name_player.text = list[position].name
        holder.itemView.id_item_name_club.text = list[position].club
        holder.itemView.id_item_best_record.text = list[position].record
    }

    override fun getItemCount(): Int {
        return list.size
    }

    @SuppressLint("NotifyDataSetChanged")
    fun setList(List:ArrayList<playerItem>){
        list = List
        notifyDataSetChanged()
    }

}