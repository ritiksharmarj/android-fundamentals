package com.example.androidfundamentals

import android.graphics.Color
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.LinearLayout
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class SongAdapter(private val songs: List<Songs>) :
    RecyclerView.Adapter<SongAdapter.SongViewHolder>() {

    // View Holder
    class SongViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        var tvSongTitle: TextView = itemView.findViewById(R.id.tvSongTitle)
        var tvSongDescription: TextView = itemView.findViewById(R.id.tvSongDescription)
        var songContainer: LinearLayout = itemView.findViewById(R.id.songContainer)
    }

    // Create new views
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): SongViewHolder {
        // Create a new view, which defines the UI of the song list item
        val inflater = LayoutInflater.from(parent.context)
        val view = inflater.inflate(R.layout.item_view, parent, false)
        return SongViewHolder(view)
    }

    // Replace the content of a view
    override fun onBindViewHolder(holder: SongViewHolder, position: Int) {
        holder.tvSongTitle.text = songs[position].title
        holder.tvSongDescription.text = songs[position].description

        var color = "#FFFFFF"
        if (position % 2 != 0) color = "#EEEEEE"
        holder.songContainer.setBackgroundColor(Color.parseColor(color))
    }

    // Return the size of your songs list
    override fun getItemCount(): Int {
        return songs.size
    }
}