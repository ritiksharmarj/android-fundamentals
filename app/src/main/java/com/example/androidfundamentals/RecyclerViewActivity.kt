package com.example.androidfundamentals

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.androidfundamentals.databinding.ActivityRecyclerViewBinding

class RecyclerViewActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding = ActivityRecyclerViewBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val songsObjects = mutableListOf<Songs>()
        songsObjects.add(Songs("Kesariya", "Brahmastra (Original Motion Picture Soundtrack)"))
        songsObjects.add(Songs("Fitoor", "Shamshera"))
        songsObjects.add(Songs("Mehabooba", "K.G.F. 2 (Hindi)"))
        songsObjects.add(Songs("Maan Meri Jaan", "Champagne Talk"))
        songsObjects.add(Songs("Rasiya", "Brahmastra (Original Motion Picture Soundtrack)"))
        songsObjects.add(Songs("Aankhon Se Batana", "Aankhon Se Batana"))
        songsObjects.add(Songs("Chaand Baaliyan", "Chaand Baaliyan"))
        songsObjects.add(Songs("Deva Deva", "Brahmastra (Original Motion Picture Soundtrack)"))
        songsObjects.add(Songs("Dance Ka Bhoot", "Brahmastra (Original Motion Picture Soundtrack)"))
        songsObjects.add(Songs("Raataan Lambiyan", "Shershaah"))

        binding.songList.adapter = SongAdapter(songsObjects)
        binding.songList.layoutManager = LinearLayoutManager(this)
    }
}