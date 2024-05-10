package com.example.listview

import android.media.MediaPlayer
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class Buah(val namaBuah:Array<String>,val gambarBuah:Array<Int>,val suaraBuah:Array<Int>) :
    RecyclerView.Adapter<Buah.MyViewHolder> (){
    class MyViewHolder(view: View) : RecyclerView.ViewHolder(view){
        val tvBuah = view.findViewById<TextView>(R.id.item_tv_buah)
        val imgBuah = view.findViewById<ImageView>(R.id.img_view)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_list,parent,false)
        return MyViewHolder(view)
    }

    override fun getItemCount(): Int {
        return namaBuah.size
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        holder.tvBuah.text = namaBuah[position]
        holder.imgBuah.setImageResource(gambarBuah[position])
        holder.itemView.setOnClickListener {
            val mediaPlayer = MediaPlayer.create(holder.itemView.context,suaraBuah[position])
            mediaPlayer.start()
        }
    }

}