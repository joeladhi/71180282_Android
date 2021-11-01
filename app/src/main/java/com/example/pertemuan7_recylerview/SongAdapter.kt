package com.example.pertemuan7_recylerview

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView

class SongAdapter(var listSong: ArrayList<Song>, var context: Context): RecyclerView.Adapter<SongAdapter.SongHolder>() {
    class SongHolder(val view:View): RecyclerView.ViewHolder(view){
        fun bind(song: Song, context: Context){
            view.findViewById<ImageView>(R.id.imgCover).setImageResource(song.cover)
            view.findViewById<TextView>(R.id.txtTitle).setText("#${song.rank} ${song.title}")
            view.findViewById<TextView>(R.id.txtSinger).setText(song.singer)
            view.setOnClickListener {
                Toast.makeText(context, "${song.singer}: ${song.title}",  Toast.LENGTH_SHORT).show()
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): SongHolder {
        val v = LayoutInflater.from(parent.context).inflate(R.layout.item_song, parent, false)
        return SongHolder(v)
    }

    override fun onBindViewHolder(holder: SongHolder, position: Int) {
        holder.bind(listSong[position], context)
    }

    override fun getItemCount(): Int {
        return listSong.size
    }

}